<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>我的订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
div.cart1 table th {
	line-height: 36px;
	width: 400px;
	padding: 0px 6px;
	color: #999999;
	font-weight: normal;
	text-align: center;
	border: solid 1px #e6e4e3;
	background-color: #fafafa;
}

div.cart1 table td {
	line-height: 36px;
	padding: 0px 6px;
	color: #999999;
	font-weight: normal;
	text-align: center;
	border: solid 1px #e6e4e3;
	background-color: #fafafa;
}

div.cart1 table td.td1 {
	width: 100px;
}
</style>

</head>

<body>
	<div class="container header">
		<%@ include file="top.jsp"%>
	</div>

	<div class="container cart1">
		<div align="center">
			<div class="step step1" align="center">
				<span><h2>订单详细</h2></span>
			</div>
			<table>
				<tbody>
					<tr>
						<th colspan="2">订单详细</th>
					</tr>
					<tr>
						<td class="td1">订单编号:</td>
						<td class="td2"><s:property value="model.oid" /></td>
					</tr>
					<tr>
						<td class="td1">订单总额:</td>
						<td class="td2"><s:property value="model.total" /></td>
					</tr>
					<tr>
						<td class="td1">订单创建时间:</td>
						<td class="td2"><s:property value="model.ordertime" /></td>
					</tr>
					<tr>
						<td class="td1">订单状态:</td>
					    <td class="td2">
							<s:if test="model.state == 1">			
								 未付款
							</s:if>
							<s:if test="model.state == 2">
						    	已付款,等待发货
						    </s:if>
							<s:if test="model.state == 3">
								已发货
							</s:if>
							<s:if test="model.state == 4">
								交易完成
							</s:if>
						</td>
					</tr>
					<tr>
						<td class="td1">支付宝交易单号:</td>
						<td class="td2"><s:property value="model.alipaycode" /></td>
					</tr>
					<tr>
						<td class="td1">订单付款时间:</td>
						<td class="td2"><s:property value="model.orderPayTime" /></td>
					</tr>
					<tr>
						<td class="td1">用户id:</td>
						<td class="td2"><s:property value="model.user.uid" /></td>
					</tr>
					<tr>
						<td class="td1">用户昵称:</td>
						<td class="td2"><s:property value="model.user.username" /></td>
					</tr>
					<tr>
						<td class="td1">物流类型:</td>
						<td class="td2"><s:property value="model.expresstype" /></td>
					</tr>
					<tr>
						<td class="td1">物流单号:</td>
						<td class="td2"><s:property value="model.expressnumber" /></td>
					</tr>
					<tr>
						<td class="td1">收货人姓名:</td>
						<td class="td2"><s:property value="model.name" /></td>
					</tr>
					<tr>
						<td class="td1">收货人电话：</td>
						<td class="td2"><s:property value="model.phone" /></td>
					</tr>
					<tr>
						<td class="td1">收货地址：</td>
						<td class="td2"><s:property value="model.addr" /></td>
					</tr>
				</tbody>
			</table>
		</div>


	</div>
	<div class="container footer">
		<%@ include file="bottom.jsp"%>
	</div>
</body>
</html>