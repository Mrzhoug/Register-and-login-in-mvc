package zgq.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
	
	public static <T> T request2bean(HttpServletRequest request,Class<T> beanclass){
		
		try {
		
			//1.创建要封装数据的bean
			T bean= beanclass.newInstance();
			
			//2.将Request中的数据整合到bean中
			Enumeration e =request.getParameterNames();
			while(e.hasMoreElements()){
				String name=(String) e.nextElement();
				String value=request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public static void copyBean(Object src,Object dest){
		//注册日期转换器
		ConvertUtils.register(new Converter(){
			public Object convert(Class type, Object value) {
				if(value==null){
					return null;
				}
				String str = (String) value;
				if(str.trim().equals("")){
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	//产生全球唯一的id
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
	
}
