<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/order/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单详情</strong>
					</TD>
				</tr>

				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="10%">序号</td>
								<td align="center" width="10%">订单项编号</td>
								<td align="center" width="10%">订单项商品数量</td>
								<td align="center" width="10%">总价</td>
								<td align="center" width="10%">商品信息</td>
								<td align="center" width="10%">所属订单编号</td>
							</tr>
							<s:iterator var="oo" value="list" status="status">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="#status.count" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="#oo.oiid" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="#oo.count" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="#oo.subtotal" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">
										<s:property value="#oo.product.version.brand.bname" />&nbsp;
										<s:property value="#oo.product.version.vname" />&nbsp;
										<s:property value="#oo.product.pdesc" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="#oo.order.oid" /></td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

