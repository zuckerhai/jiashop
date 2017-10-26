package com.hai.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.hai.model.ReceiveXmlEntity;

public class XmlEntity<T> {
	
	public T GetEntity(String xml,Class c){
		T msg=null;
		Document xmDoc;
		try {
			 xmDoc=(Document) DocumentHelper.parseText(xml); 
	            // 获得文档的根节点  
	            Element root = xmDoc.getRootElement();  
	            // 遍历根节点下所有子节点  
	            Iterator<?> iter = root.elementIterator();  
	            msg = (T)c.newInstance();//创建这个实体的对象  	              
	            while(iter.hasNext()){  
	                Element ele = (Element)iter.next();  
	                //获取set方法中的参数字段（实体类的属性）  
	                Field field = c.getDeclaredField(ele.getName());  
	                //获取set方法，field.getType())获取它的参数数据类型  
	                Method method = c.getDeclaredMethod("set"+ele.getName(), field.getType());  
	                //调用set方法  
	                method.invoke(msg, ele.getText());  
	            }
		} catch (Exception e) {
            System.out.println("xml 格式异常: "+ xml); 
			e.printStackTrace();
		}
		return msg;
	}
	
    /** 
     * 封装文字类的返回消息 
     * @param to 
     * @param from 
     * @param content 
     * @return 
     */  
    public String formatXmlAnswer(String to, String from, String content) {  
        StringBuffer sb = new StringBuffer();  
        Date date = new Date();  
        sb.append("<xml><ToUserName><![CDATA[");  
        sb.append(to);  
        sb.append("]]></ToUserName><FromUserName><![CDATA[");  
        sb.append(from);  
        sb.append("]]></FromUserName><CreateTime>");  
        sb.append(date.getTime());  
        sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");  
        sb.append(content);  
        sb.append("]]></Content><FuncFlag>0</FuncFlag></xml>");  
        return sb.toString();  
    }
	

}
