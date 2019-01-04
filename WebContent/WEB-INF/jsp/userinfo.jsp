<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>我的个人信息</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
div.cart2 table tr {
	line-height: 36px;
	width: 600px;
	padding: 0px 6px;
	color: #999999;
	font-weight: normal;
	text-align: center;
	border: solid 1px #e6e4e3;
	background-color: #fafafa;
}

div.cart2 table td {
	line-height: 36px;
	padding: 0px 6px;
	color: #999999;
	font-weight: normal;
	text-align: center;
	border: solid 1px #e6e4e3;
	background-color: #fafafa;
}

div.cart2 table td.td1 {
	width: 100px;
}
div.cart2 table td.td2 {
	width: 400px;
}
div.cart2 table td.td2 input{
	width: 400px;
}
</style>
</head>
<body width="700">

	<div class="container header">
		<%@ include file="top.jsp"%>
	</div>

	<div class="container cart2">
		<div class="span24">
			<div class="step step1" align="center">
				<span><h2>我的个人信息</h2></span>
			</div>
			
			<form id="orderForm" action="${ pageContext.request.contextPath }/user_infoupdate.action" method="post">
				<div class="span24" align="center">
					<hr />
					<table>
					    <tr>
					        <td class="td1">用户id:</td>
					        <td class="td2"><s:property value="#session.existUser.uid"/></td>
					        <!--  
					            <td class="td2"><input name="uid" type="text" readonly="true" value="<s:property value="#session.existUser.uid"/>" /></td>
					        -->
					    </tr>
					    <tr>
					        <td class="td1">用户昵称:</td>
					        <td class="td2"><input name="username" type="text" value="<s:property value="#session.existUser.username"/>" /></td>
					    </tr>
					    <tr>
					        <td class="td1">用户密码:</td>
					        <td class="td2"><input name="password" type="password" value="<s:property value="#session.existUser.password"/>" /></td>
					    </tr>
					    <tr>
					        <td class="td1">邮箱:</td>
					        <td class="td2"><input name="email" type="text" value="<s:property value="#session.existUser.email"/>" /></td>
					    </tr>
					    <tr>
					        <td class="td1">收货人:</td>
					        <td class="td2"><input name="name" type="text" value="<s:property value="#session.existUser.name"/>" /></td>
					    </tr>
					    <tr>
					        <td class="td1">联系方式:</td>
					        <td class="td2"><input name="phone" type="text" value="<s:property value="#session.existUser.phone"/>" /></td>
					    </tr>
					    <tr>
					        <td class="td1">收货地址:</td>
					        <td class="td2"><input name="addr" type="texta" value="<s:property value="#session.existUser.addr"/>"/></td>
					    </tr>
					</table>
				</div>
				<div class="span24">
					<p style="text-align: center">
						<a href="javascript:document.getElementById('orderForm').submit();"><font color="blue" size="3">点击确认修改</font></a>
					</p>
				</div>
				<div class="span24">
				    
					<p style="text-align: center">
					    &nbsp
					</p>
					<p style="text-align: center">
					    &nbsp
					</p>
					<p style="text-align: center">
					    &nbsp
					</p>
					<p style="text-align: center">
					    &nbsp
					</p>
					<p style="text-align: center">
					    &nbsp
					</p>
					<p style="text-align: center">
					    &nbsp
					</p>
					<p style="text-align: center">
					    &nbsp
					</p>
					<p style="text-align: center">
					    &nbsp
					</p>
					<p style="text-align: center">
					    &nbsp
					</p>
					<hr />
				</div>
			</form>
		</div>
	</div>
	<div class="container footer">
		<%@ include file="bottom.jsp"%>
	</div>
</body>
</html>