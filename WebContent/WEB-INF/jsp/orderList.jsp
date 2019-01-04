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

</head>
<body>
	<div class="container header">
		<%@ include file="top.jsp"%>
	</div>

	<div class="container cart">
		<!-- 如果该用户没有订单-->
		<s:if test="pageBean==null">
		    <div class="span24" align="center">
				<div class="step step1" align="center">
					<span><h2>亲!您还没有订单!请先去购物!</h2></span>
				</div>
			</div>
		</s:if>
		<s:else>
			<div class="span24">
				<div class="step step1" align="center">
					<span><h2>我的订单</h2></span>
				</div>
				<table>
					<tbody>
					    <tr>
							<th>图片</th>
							<th>商品</th>
							<th>单价</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<s:iterator var="order" value="pageBean.list">
							<tr>
							    <th colspan="2">
							                订单创建时间:<s:property value="#order.ordertime" />&nbsp;&nbsp;&nbsp;
							                订单编号:<s:property value="#order.oid" />&nbsp;&nbsp;&nbsp;
									订单金额:<s:property value="#order.total" />元&nbsp;&nbsp;&nbsp;
							    </th>
								<th colspan="1">       
									订单状态:
									<s:if test="#order.state == 1">					
											 未付款，<a href="${ pageContext.request.contextPath }/order_findOrderByOid.action?oid=<s:property value="#order.oid" />"><font color="blue">点击付款</font></a>
									</s:if>
									<s:else>
									    <s:if test="#order.state == 2">
					    			 	   	已付款,等待发货&nbsp;&nbsp;&nbsp;&nbsp;
								    	</s:if> 
									    <s:if test="#order.state == 3">
											已发货，<a href="${ pageContext.request.contextPath }/order_updateState.action?oid=<s:property value="#order.oid" />&state=4"><font color="blue">点击确认收货</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
								    	</s:if> 
								    	<s:if test="#order.state == 4">
									    	交易完成&nbsp;&nbsp;&nbsp;&nbsp;
								    	</s:if>							    
									</s:else>
								</th>
								<th colspan="2">
								     <s:if test="#order.state == 1">
								          <a href="${ pageContext.request.contextPath }/order_orderDetail.action?oid=<s:property value="#order.oid" />"><font color="blue">查看订单详细</font></a>&nbsp&nbsp&nbsp
								          <a href="${ pageContext.request.contextPath }/order_deleteOrder.action?oid=<s:property value="#order.oid" />"><font color="blue">删除</font></a>
								     </s:if>
								     <s:else>
								     	  <a href="${ pageContext.request.contextPath }/order_orderDetail.action?oid=<s:property value="#order.oid" />"><font color="blue">查看订单详细</font></a>&nbsp&nbsp&nbsp
								     </s:else>
								</th>
							</tr>
							
							<s:iterator var="orderItem" value="#order.orderItems">
								<tr>
									<td width="60"><img
										src="${ pageContext.request.contextPath }/<s:property value="#orderItem.product.version.vimg"/>" />
									</td>
									<td>
									   <s:property value="#orderItem.product.version.brand.bname" />&nbsp;
									   <s:property value="#orderItem.product.version.vname" />&nbsp;
									   <s:property value="#orderItem.product.pdesc" />
									</td>
									<!--  
									<td>
										<s:property value="#orderItem.product.pname" />
									</td>
									-->
									<td width="220">￥<s:property value="#orderItem.product.pprice" /></td>
									<td class="quantity" width="60"><s:property
											value="#orderItem.count" /></td>
									<td width="60">￥<span class="subtotal"><s:property
												value="#orderItem.subtotal" />
									</span></td>
								</tr>
							</s:iterator>
						</s:iterator>
						<tr>
							<th colspan="5" align="center">
								<!-- 分页信息 -->
								<div class="pagination">
								    <!-- 只有一页 -->
									<s:if test="pageBean.totalPage==1">
										 <a href="#" >首页&nbsp;</a>
										 <a href="#" >上一页&nbsp;</a>
										 <span>第<s:property value="pageBean.page" />/<s:property value="pageBean.totalPage" />页</span>
									     <a href="#">下一页&nbsp;</a>
										 <a href="#">尾页&nbsp;</a>
									</s:if>
									<!-- 不止一页 -->
									<s:else>
									     <!-- 当前在首页 -->
									     <s:if test="pageBean.page==1">
									         <a href="#" >首页&nbsp;</a>
						                     <a href="#" >上一页&nbsp;</a>
										     <span>第<s:property value="pageBean.page" />/<s:property value="pageBean.totalPage" />页</span>
									         <a href="${ pageContext.request.contextPath }/order_findOrderByUid.action?page=<s:property value="pageBean.page+1"/>">下一页&nbsp;</a>
										     <a  href="${ pageContext.request.contextPath }/order_findOrderByUid.action?page=<s:property value="pageBean.totalPage"/>">尾页&nbsp;</a>
									     </s:if>
									     <!-- 当前在尾页 -->
									     <s:elseif test="pageBean.page==pageBean.totalPage">
									         <a href="${ pageContext.request.contextPath }/order_findOrderByUid.action?page=1" >首页&nbsp;</a>
						                     <a href="${ pageContext.request.contextPath }/order_findOrderByUid.action?page=<s:property value="pageBean.page-1"/>" >上一页&nbsp;</a>
										     <span>第<s:property value="pageBean.page" />/<s:property value="pageBean.totalPage" />页</span>
									         <a href="#">下一页&nbsp;</a>
										     <a  href="#">尾页&nbsp;</a>
									     </s:elseif>
									     <!-- 当前不在首页也不在尾页 -->
									     <s:else>
									          <a href="${ pageContext.request.contextPath }/order_findOrderByUid.action?page=1" >首页&nbsp;</a>
						                     <a href="${ pageContext.request.contextPath }/order_findOrderByUid.action?page=<s:property value="pageBean.page-1"/>" >上一页&nbsp;</a>
										     <span>第<s:property value="pageBean.page" />/<s:property value="pageBean.totalPage" />页</span>
									         <a href="${ pageContext.request.contextPath }/order_findOrderByUid.action?page=<s:property value="pageBean.page+1"/>">下一页&nbsp;</a>
										     <a  href="${ pageContext.request.contextPath }/order_findOrderByUid.action?page=<s:property value="pageBean.totalPage"/>">尾页&nbsp;</a>
									     </s:else>		   
									</s:else>	
								</div>
								
							</th>
						</tr>
					</tbody>
				</table>
			</div>
		</s:else>
	</div>
	<div class="container footer">
		<%@ include file="bottom.jsp"%>
	</div>
</body>
</html>