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
					<strong>热门商品</strong>
				</div>
				<ul class="tab">
				</ul>

				<ul class="tabContent" style="display: block;">
					<!-- 热门型号展示  迭代输出 -->
					<s:iterator var="v" value="hotVersionList">
						<li>
						    <a href="${pageContext.request.contextPath}/version_findByVid.action?vid=<s:property value="#v.vid"/>"> 
						       <img src="${pageContext.request.contextPath}/<s:property value="#v.vimg"/>" style="display: block;" />
							   <p style="width: 100%;height: 20px;display: block;line-height: 20px;text-align: center;">
								   <s:property value="#v.vname" />
							   </p>
							   <p style="width: 100%;height: 20px;display: block;line-height: 20px;text-align: center;">
								   <s:property value="#v.vprice" />
							   </p>
						    </a>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>

		<!-- 中部底横栏 -->
		<div class="span24">
			<div class="friendLink">
				<dl>
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