1.搭建开发环境
	1.1，导入开发包
		dom4j开发包
		jstl开发包
		beanUtils开发包
		log4j开发包
	1.2，创建组织程序的开发包
		zgq.domain
		zgq.dao
		zgq.dao.impl
		zgq.service
		zgq.service.impl
		zgq.web.controller
		zgq.web.UI
		zgq.utils
		junit.test
		
		WEB-INF/jsp
	1.3,创建代表数据库的xml文件
		在类目录下创建一个代表数据库的users.xml
2.开发步骤
	2.1首先开发javabean  
		在daomian包里面创建User.java并封装
	2.2dao层的实现
		2.2.1写dao层的实现类
			在dao.impl里写UserDaoImpl.java
		2.2.2将调用方法写入工具类中 XmlUtils
			写入getDocument和write2Xml两个方法
		2.2.3写测试类UserDaoTest 
			每一层写完就要进行测试	
		2.2.4提取dao的接口  
			refactor--extract interface
	2.3service层的实现
		2.2.1写service层的实现类
			在Service.impl中写BusinessService类
		2.2.2将密码加密方法写入ServiceUtils类
			写md5方法
		2.2.3写测试方法
	2.4web层实现
		2.4.1index.jsp实现两个功能：注册和登录
			注册功能跳转至web.UI包中的RegisterUIServlet
			登录功能跳转至web.UI包中的LoginUIServlet
		2.4.2RegisterUIServlet跳转至register.jsp页面显示
		2.4.3用户在输入信息之后，点击注册，数据跳转至RegisterServlet页面
			RegisterServlet与用户请求有关，固放在web.controller包中
		2.4.4创建registerForm这个javabean对注册用户输入的数据进行校验
		2.4.5创建WebUtils工具类可以方便封装数据  
			WebUtils中写入一个copybean方法，如果注册表单成功，将form copy 到user中
		2.4.6生成BusinessServiceImpl对象，调用register方法
			写出几个结果进行分析
3.Login页面的实现
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

			
		
		
		
		
		
		
		
		
	
	
	