package com.hai.controller;

import com.hai.common.SignUtil;
import com.hai.common.TulingApiProcess;
import com.hai.common.XmlEntity;
import com.hai.model.ReceiveXmlEntity;
import com.hai.model.SNSUserInfo;
import com.hai.model.SysUser;
import com.hai.model.WeixinOauth2Token;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"WeChart"})
public class WeChartController
{
  @RequestMapping(value={"/connect"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
  public void connectWeixin(HttpServletRequest request, HttpServletResponse response)
  {
    String signature = request.getParameter("signature");

    String timestamp = request.getParameter("timestamp");

    String nonce = request.getParameter("nonce");

    String echostr = request.getParameter("echostr");

    StringBuffer sb = new StringBuffer();
    try
    {
      InputStream is = request.getInputStream();
      InputStreamReader isr = new InputStreamReader(is, "UTF-8");
      BufferedReader br = new BufferedReader(isr);
      String s = "";
      while ((s = br.readLine()) != null) {
        sb.append(s);
      }
    }
    catch (IOException e1)
    {
      e1.printStackTrace();
    }

    String xml = sb.toString();
    String result = "";

    if ((echostr != null) && (echostr.length() > 1) && (SignUtil.checkSignature(signature, timestamp, nonce))) {
      result = echostr;
    }
    else {
      result = process(xml);
    }
    try
    {
      OutputStream os = response.getOutputStream();
      os.write(result.getBytes("UTF-8"));
      os.flush();
      os.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String process(String inXml)
  {
    ReceiveXmlEntity xmlEntity = (ReceiveXmlEntity)new XmlEntity().GetEntity(inXml, ReceiveXmlEntity.class);

    String result = "";
    if ("text".endsWith(xmlEntity.getMsgType())) {
      result = new TulingApiProcess().getTulingResult(xmlEntity.getContent());
    }
    if ("event".endsWith(xmlEntity.getMsgType()))
    {
      "subscribe".equals(xmlEntity.getEvent());

      "unsubscribe".equals(xmlEntity.getEvent());

      result = "欢迎订阅本公众号";
    }

    result = new XmlEntity().formatXmlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), result);

    return result;
  }
  @RequestMapping(value={"/authwx"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public void OAuthWx(HttpServletRequest request, HttpServletResponse response, ModelAndView view, Model model) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    String code = request.getParameter("code");
    String state = request.getParameter("state");

    if (!"authdeny".equals(code))
    {
      WeixinOauth2Token weixinOauth2Token = WeXinUtil.getOauth2AccessToken("wx54e38f7950b07910", "b433627c6e57351a786d5da83ec89ead", code);

      String accessToken = weixinOauth2Token.getAccessToken();

      String openId = weixinOauth2Token.getOpenId();

      SNSUserInfo snsUserInfo = WeXinUtil.getSNSUserInfo(accessToken, openId);
      if (snsUserInfo.getHeadimgurl().equals("")) {
        snsUserInfo.setHeadimgurl("assets/avatars/avatar2.png");
      }

      request.getSession().setAttribute("snsUserInfo", snsUserInfo);
      request.setAttribute("state", state);

      SysUser sysUser = new SysUser();
      sysUser.setUsername(snsUserInfo.getNickname());
      request.getSession().setAttribute("curruser", sysUser);
    }

    response.sendRedirect("/hai/index.jsp");
  }
}