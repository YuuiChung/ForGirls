<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@include file="/public/head.jspf" %>	
  </head>
  <body>
  	 此页面用来显示错误消息
  	<s:property value="exception"/>
  	<s:property value="exception.message"/>
  	<hr />
  	${exception} <br />
  	${exception.message}
  </body>
</html>
