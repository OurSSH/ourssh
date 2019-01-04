<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%> 
<div class="span5">
	
	  <div class="logo">
		<a href="./index.action"> 
		<img src="${pageContext.request.contextPath}/image/mylogo.png" width="58" height="50" alt="" />
		</a>
	</div>

</div>
<div class="span9">
<!--  
	<div class="headerAd">
	 <img src="${pageContext.request.contextPath}/image/header.jpg"
			width="320" height="20" alt="正品保障" title="正品保障" />
	<div class="step step1" align="center">
		<span><h2>订单确认付款页面</h2></span>
	</div>
	</div>
	-->
</div>
<div class="span10 last" align="right" style="float:right; right:20px; margin-top:25px;">
	<div class="topNav clearfix" width="950">
		<ul>
			<s:if test="#session.existUser == null">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a
					href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/user_registPage.action">注册</a>|
				</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
				     <a href="${ pageContext.request.contextPath }/cart_myCart.action">购物车</a>
				</li>
			</s:if>
			<s:else>
			    <li>
			    </li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${ pageContext.request.contextPath }/user_info.action?uid=<s:property value="#session.existUser.uid" />"><s:property value="#session.existUser.name" />
					</a>  |
				</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${ pageContext.request.contextPath }/order_findOrderByUid.action?page=1">我的订单</a> |
				</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
				     <a href="${ pageContext.request.contextPath }/cart_myCart.action">购物车</a>|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/user_logout.action">退出</a>|
				</li>
			</s:else>
	        <!-- 
			<li><a>会员中心</a> |</li>
			<li><a>关于我们</a></li>
			 -->
		</ul>
	</div>
	<!--  
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
	-->
</div>
<!-- 品牌导航栏目 -->
<div class="span24">
	<ul class="mainNav">
		<li><a href="${ pageContext.request.contextPath }/index.action">首页</a>
			|
		</li>
		<s:iterator var="brand" value="#session.brandList">
			<li>
			     <a href="${ pageContext.request.contextPath }/brand_findByPageBid.action?bid=<s:property value="#brand.bid"/>&bname=<s:property value="#brand.bname"/>&page=1"   />   <s:property value="#brand.bname"/>  </a> |
			</li>
		</s:iterator>
	</ul>
</div>