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
	<form
		action="${pageContext.request.contextPath }/AdminCustomer_KeySearch.action?page=<s:property value="pageBean.page" />"
		method="post">
		<table>
			<tr>
				<td>查询方式：<select name="key">
						<option value="username">用户名</option>
						<option value="name">姓名</option>
						<option value="email">邮箱</option>
						<option value="phone">电话</option>
						<option value="addr">地址</option>
				</select></td>
				<td>关键字：<input name="value" type=text /></td>
				<td><input type="submit" value="搜索"></td>
			</tr>
		</table>
	</form>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/customer/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>用户列表</strong>
					</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="7%">序号</td>
								<td align="center" width="7%">用户id</td>
								<td align="center" width="7%">用户名</td>
								<td align="center" width="7%">密码</td>
								<td width="7%" align="center">姓名</td>
								<td width="10%" align="center">邮箱</td>
								<td width="10%" align="center">电话</td>
								<td width="10%" align="center">默认地址</td>
								<td width="4%" align="center">激活状态</td>
								<td width="7%" align="center">激活码</td>
								<td width="4%" align="center">编辑</td>
								<td width="4%" align="center">删除</td>
							</tr>
							<s:iterator var="u" value="pageBean.list" status="status">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#status.count" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#u.uid" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#u.username" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#u.password" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#u.name" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="#u.email" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="#u.phone" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="#u.addr" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="4%"><s:property value="#u.state" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#u.code" /></td>
									<td align="center" style="HEIGHT: 22px"><a
										href="${ pageContext.request.contextPath }/AdminCustomer_findbyId.action?uid=<s:property value="#u.uid"/>&page=<s:property value="pageBean.page" />">
											<img
											src="${pageContext.request.contextPath}/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</a></td>

									<td align="center" style="HEIGHT: 22px"><a
										href="${ pageContext.request.contextPath }/AdminCustomer_delete.action?uid=<s:property value="#u.uid"/>&page=<s:property value="pageBean.page" />">
											<img
											src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
				<tr align="center">
					<td colspan="7">第<s:property value="pageBean.page" />/<s:property
							value="pageBean.totalPage" />页 <s:if test="pageBean.page != 1">
							<a
								href="${pageContext.request.contextPath}/AdminCustomer_findall.action?page=1">首页</a>|
								<a
								href="${pageContext.request.contextPath}/AdminCustomer_findall.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
							</s:if> <s:if test="pageBean.page != pageBean.totalPage">
							<a
								href="${pageContext.request.contextPath}/AdminCustomer_findall.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
								<a
								href="${pageContext.request.contextPath}/AdminCustomer_findall.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>|
							</s:if>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

