<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>手机商城</title>
<link href="${pageContext.request.contextPath}/css/slider.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
</head>
<!-- 本页面为某品牌的所有型号的展示页 -->
<body>
	<!-- 顶部栏 -->
	<div class="container header">
		<%@ include file="top.jsp"%>
	</div>

	<!-- 中部栏 -->
	<div class="container index">
		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
				<div class="title">
					<strong><s:property value="model.bname"/>手机所有型号</strong>
				</div>
				<ul class="tab">
				</ul>

				<ul class="tabContent" style="display: block;">
					<!-- 该品牌所有型号展示  迭代输出 -->
					<s:iterator var="v" value="brandVersionList">
						<li><a
							href="${pageContext.request.contextPath}/version_findByVid.action?vid=<s:property value="#v.vid"/>"
							target="_blank"> <img
								src="${pageContext.request.contextPath}/<s:property value="#v.vimg"/>"
								style="display: block;" />
								<p>
									<s:property value="#v.vname" />
								</p>&nbsp&nbsp
								<p>
									<s:property value="#v.vprice" />
								</p>
						</a></li>
					</s:iterator>
				</ul>
			</div>
			
		</div>

		<!-- 中部底横栏 -->
		<div class="span24">
			<div class="friendLink">
				<dl>
					<dt>新手指南</dt>
					<dd>
						<a target="_blank">支付方式</a> |
					</dd>
					<dd>
						<a target="_blank">配送方式</a> |
					</dd>
					<dd>
						<a target="_blank">售后服务</a> |
					</dd>
					<dd>
						<a target="_blank">购物帮助</a> |
					</dd>
					<dd>
						<a target="_blank">蔬菜卡</a> |
					</dd>
					<dd>
						<a target="_blank">礼品卡</a> |
					</dd>
					<dd>
						<a target="_blank">银联卡</a> |
					</dd>
					<dd>
						<a target="_blank">亿家卡</a> |
					</dd>

					<dd class="more">
						<a>更多</a>
					</dd>
				</dl>
			</div>
		</div>


	</div>

	<!-- 底部栏 -->
	<div class="container footer">
		<%@ include file="bottom.jsp"%>
	</div>


</body>
</html>