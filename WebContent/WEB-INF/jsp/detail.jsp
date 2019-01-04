<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/admin.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript">
     function saveCart(){
         document.getElementById("cartForm").submit();
     }
</script>
<script>
/*
	function checkForm() {
		var 
		if ((document.theForm.fenshu.value.indexOf("-") == 0)||!(document.theForm.fenshu.value.indexOf(".") == -1)){
			 alert("分数不能为小数或负数");
			document.theForm.fenshu.focus();
			 return false;
			 } 

		
		// 至少选择一个产品:
		var username = document.getElementById("username").value;
		if (username == null || username == '') {
			alert("用户名不能为空!");
			return false;
		}
		
		//购买数量必须为大于0的数字
		var username = document.getElementById("username").value;
		if (username == null || username == '') {
			alert("用户名不能为空!");
			return false;
		}
		*/
	}
	/*
	function checkUsername() {
		// 获得文件框值:
		var username = document.getElementById("username").value;
		// 1.创建异步交互对象
		var xhr = createXmlHttp();
		// 2.设置监听
		xhr.onreadystatechange = function() {
			//回调
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					document.getElementById("span1").innerHTML = xhr.responseText;
				}
			}
		}
		// 3.打开连接
		xhr.open("GET",
				"${pageContext.request.contextPath}/user_findByName.action?time="
						+ new Date().getTime() + "&username=" + username, true);
		// 4.发送
		xhr.send(null);
	}

	function createXmlHttp() {
		var xmlHttp;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		return xmlHttp;
	}*/


</script>
</head>
<body>
	<!-- 顶部栏 -->
	<div class="container header">
		<%@ include file="top.jsp"%>
	</div>


	<div class="container productContent" style="padding-top:0px; padding-bottom:0px;">
		<div class="span18 last" style="margin-top:0px; padding-top:0px; padding-bottom:0px;">
			<div class="productImage">
				<a title="" style="outline-style: none; text-decoration: none;"
					id="zoom" href="#" rel="gallery"> <!-- 商品图片div -->
					<div class="zoomPad">
						<img style="opacity: 1;" class="medium"
							src="${pageContext.request.contextPath}/<s:property value="model.vimg"/>">
						<div
							style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;"
							class="zoomPup"></div>
						<div
							style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;"
							class="zoomPreload">Loading zoom</div>
					</div>
				</a>

			</div>
			<div class="name" style="position: relative;right: 120px;top: 100px; ">
				<s:property value="model.vname"/>
			</div>
			<div class="info" style="position: relative;right: 120px;top: 50px; ">
				<dl>
					<dt>价格:</dt>
					<dd>
						<strong>￥：<s:property value="model.vprice" /> 元
						</strong>
					</dd>
				</dl>
				<dl>
					<dt>促销:</dt>
					<dd>
						<a target="_blank" title="限时抢购 ">限时抢购</a>
					</dd>
				</dl>
				<dl>
					<dt></dt>
					<dd>
						<span> </span>
					</dd>
				</dl>
			</div>
			<div class="" style="
  position: absolute;
  left: 555px;
  top: 300px;
  ">
				<table border="1">
					<tr>
						<th>选择</th>
						<th>配置</th>
						<th>价格</th>
						<th>库存</th>
						<th>购买数量</th>
					</tr>
					<form id="cartForm" action="${pageContext.request.contextPath}/cart_addCart.action" method="post">
						<s:iterator var="p" value="model.products">
							<tr>
								<td><input class="chockboxlist" name="pid" type="checkbox" value="<s:property value="#p.pid"/>"></td>
								<td><s:property value="#p.pdesc" /></td>
								<td><s:property value="#p.pprice" /></td>
								<td><s:property value="#p.pstock" /><span id="pstockspan"></span></td>
								<td><input name="<s:property value="#p.pid"/>" value="0" id=""></td>
							</tr>
						</s:iterator>
						<div class="buy">
							<input id="addCart" class="addCart" value="加入购物车" type="button" onclick="saveCart()">
						</div>
					</form>
				</table>
			</div>
			<div id="bar" class="bar">
				<ul>
					<li id="introductionTab"><a href="#">商品介绍</a></li>
				</ul>
			</div>

			<div id="introduction" name="introduction" class="introduction">
				<div class="title">
					<strong><s:property value="model.vdesc" /></strong>
				</div>
				<div>
					<img
						src="${pageContext.request.contextPath}/<s:property value="model.vimg"/>" />
					<img
						src="${pageContext.request.contextPath}/<s:property value="model.vimg"/>"
						style="display: block;" />
				</div>
			</div>



		</div>
	</div>
	<!-- 底部栏 -->
	<div class="container footer" style="margin-top: 3000px;">
		<%@ include file="bottom.jsp"%>
	</div>
</body>
</html>