<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="StyleSheet" href="../css/dtree.css" type="text/css" />
<script type="text/javascript" src="../js/dtree.js"></script>
<title>树形结构显示</title>
</head>
<body>
	<div class="dtree">
	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
		<script language="JavaScript">
			//新建一个树形显示页面
			d = new dTree('d');
			//添加一个根节点 '01'为根节点的id,'-1'表示没有附属节点即为根节点，商城管理系统为根节点的名字
			d.add('01', -1, '商城管理系统');
			//用户管理
			d.add('0104','01','用户管理');
			//用户信息管理
			d.add('010401','0104','用户信息管理','${pageContext.request.contextPath}/AdminCustomer_findall.action?page=1','','right');
			//根节点的子节点
			d.add('0101', '01', '手机品牌分类');
			//子节点的节点查找所有品牌跳转链接，right右边显示 空出来的为子节点的标题（title）
			d.add('010101', '0101', '手机品牌管理','${pageContext.request.contextPath}/AdminBrand_findallBrand.action','','right');
			//型号
			d.add('0102','01','手机型号分类');
			d.add('010201','0102','手机型号管理','${pageContext.request.contextPath}/AdminVersion_findallVersion.action?page=1','','right');
			//商品
			d.add('0103','01','商品分类');
			d.add('010301','0103','商品管理','${pageContext.request.contextPath}/AdminProduct_findallProduct.action?page=1','','right');
			//订单管理
			d.add('0105','01','订单管理');
			d.add('010501','0105','订单管理','${pageContext.request.contextPath}/AdminOrder_findallOrder.action?page=1','','right');
			//将树形结构在页面显示出来
			document.write(d);
		</script>
	</div>
</body>
</html>