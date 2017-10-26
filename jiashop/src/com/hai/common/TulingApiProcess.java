package com.hai.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 调用图灵机器人api接口，获取智能回复内容
 * 
 * @author pamchen-1
 * 
 */
public class TulingApiProcess {
	/**
	 * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果
	 * 
	 * @param content
	 * @return
	 */
	public String getTulingResult(String content) {
		String APIKEY = "d5556cb53c3d4b16ae371662e76af5d0";
		String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY
				+ "&info=";
		String param = "";
		try {
			param = getURL + URLEncoder.encode(content, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 将参数转为url编码

		/** 发送httpget请求 */
		HttpGet request = new HttpGet(param);
		String result = "";
		try {
			HttpResponse response = HttpClients.createDefault()
					.execute(request);
			if (response.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/** 请求失败处理 */
		if (null == result) {
			return "对不起，你说的话真是太高深了……";
		}
		ObjectMapper objectMapper=new ObjectMapper();
		Map rstMap=null;
		try {
			 rstMap=objectMapper.readValue(result, Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(Integer.parseInt(rstMap.get("code").toString())==100000){
			result=rstMap.get("text").toString();
			
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		TulingApiProcess myRobotApiProcess=new TulingApiProcess();
		
		System.out.println(myRobotApiProcess.getTulingResult("你叫什么名字"));
		
		
	}
}