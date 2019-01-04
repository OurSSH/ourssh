<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>购物车</title>

<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />


</head>
<body>
	<div class="container header">
		<%@ include file="top.jsp"%>
	</div>

	<div class="container cart">
	    <!-- 如果购物车中有东西 则展示购物项列表 -->
		<s:if test="#session.cart.cartItems.size() != 0">
			<div class="span24">
				<div class="step step1" align="center">
				<span><h2>购物车</h2></span>
				</div>
				<table>
					<tbody>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
							<th>操作</th>
						</tr>
						<s:iterator var="cartItem" value="#session.cart.cartItems">
							<tr>
								<td width="60"><img src="${pageContext.request.contextPath}/<s:property value="#cartItem.product.version.vimg"/>"></td>
								<td><a target="_blank"><s:property value="#cartItem.product.version.vname" />&nbsp<s:property value="#cartItem.product.pdesc" /></a></td>
								<td>￥<s:property value="#cartItem.product.pprice" /></td>
								<td class="quantity" width="60"><s:property value="#cartItem.count" /></td>
								<td width="140"><span class="subtotal">￥<s:property value="#cartItem.subtotal" /></span></td>
								<td><a href="${ pageContext.request.contextPath }/cart_removeCart.action?pid=<s:property value="#cartItem.product.pid"/>"
									class="delete">删除</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">商品金额: <strong id="effectivePrice">￥<s:property value="#session.cart.total" />元</strong>
				</div>
				<div class="bottom">
					<a href="${ pageContext.request.contextPath }/cart_clearCart.action" id="clear" class="clear">清空购物车</a> 
					<a href="${ pageContext.request.contextPath }/order_save.action" id="submit" class="submit">提交订单</a>
				</div>
			</div>
		</s:if>
		<!-- 如果购物车中什么都没有 提示返回购物-->
		<s:else>
			<div class="span24" align="center">
				<div class="step step1" align="center">
					<span><h2>亲!您还没有购物!请先去购物!</h2></span>
				</div>
			</div>
		</s:else>
	</div>
	<div class="container footer">
		<%@ include file="bottom.jsp"%>
	</div>
</body>
</html>