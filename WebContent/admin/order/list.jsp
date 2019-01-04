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
			action="${pageContext.request.contextPath }/AdminOrder_KeySearch.action?page=<s:property value="pageBean.page" />"
			method="post">
			<table>
			<tr>
			<td >查询方式：<select name="key">
				<option value="oid">订单编号</option>
				<option value="name">收货人</option>
				<option value="alipaycode">支付码</option>
				<option value="addr">收货地址</option>
				<option value="uid">用户id</option>
			</select></td><td>关键字：<input name="value" type=text/></td> <td><input type="submit" value="搜索"></td></tr>
			</table>
		</form>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/order/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单列表</strong>
					</TD>
				</tr>

				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="8%">订单编号</td>
								<td align="center" width="4%">订单金额</td>
								<td align="center" width="7%">创建时间</td>
								<td align="center" width="7%">付款时间</td>
								<td align="center" width="5%">订单状态</td>
								<td align="center" width="5%">收货人</td>
								<td align="center" width="6%">联系方式</td>
								<td align="center" width="13%">收货地址</td>
								<td align="center" width="5%">用户id</td>
								<td align="center" width="5%">用户姓名</td>
								<td align="center" width="7%">支付码</td>
								<td align="center" width="5%">实际金额</td>
								<td align="center" width="10%">快递单号</td>
								<td align="center" width="10%">订单详情</td>
								<td width="4%" align="center">删除</td>
							</tr>
							<s:iterator var="o" value="pageBean.list" status="status">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%"><s:property value="#o.oid" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="4%"><s:property value="#o.total" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#o.ordertime" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#o.orderPayTime" /></td>

									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%">
										<s:if test="#o.state==1">
													未付款
												</s:if> <s:if test="#o.state==2">
											<a
												href="${ pageContext.request.contextPath }/AdminOrder_updateState.action?oid=<s:property value="#o.oid" />&page=<s:property value="pageBean.page" />"><font
												color="blue">发货</font></a>
										</s:if> <s:if test="#o.state==3">
													等待确认收货
												</s:if> <s:if test="#o.state==4">
													订单完成
												</s:if></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%"><s:property value="#o.name" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="6%"><s:property value="#o.phone" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="13%"><s:property value="#o.addr" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%"><s:property value="#o.user.uid" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%"><s:property value="#o.user.username" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#o.alipaycode" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%"><s:property value="#o.realpaytotal" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">
										 
										<s:if test="#o.expressnumber!=0">
											<s:property value="#o.expressnumber" />
											<a
												href="${ pageContext.request.contextPath }/AdminOrder_addExpressnumber.action?oid=<s:property value="#o.oid"/>&page=<s:property value="pageBean.page" />"><font
												color="blue">修改</font></a>
										</s:if> 
										<s:if test="#o.expressnumber==0">
											<a
												href="${ pageContext.request.contextPath }/AdminOrder_addExpressnumber.action?oid=<s:property value="#o.oid"/>&page=<s:property value="pageBean.page" />"><font
												color="blue">填写快递单号</font></a>
										</s:if>
									    
									    <!--  
									    <s:if test='{#o.expressnumber!="0"}'>
											<s:property value="#o.expressnumber" />
											<a
												href="${ pageContext.request.contextPath }/AdminOrder_addExpressnumber.action?oid=<s:property value="#o.oid"/>&page=<s:property value="pageBean.page" />"><font
												color="blue">修改</font></a>
										</s:if> 
										<s:else>
											<a
												href="${ pageContext.request.contextPath }/AdminOrder_addExpressnumber.action?oid=<s:property value="#o.oid"/>&page=<s:property value="pageBean.page" />"><font
												color="blue">填写快递单号</font></a>
										</s:else>
										-->
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="5%"><a
										href="${ pageContext.request.contextPath }/AdminOrder_findOrderItem.action?oid=<s:property value="#o.oid"/>"><font
											color="blue">订单详情</font></a></td>
									<td align="center" style="HEIGHT: 22px" width="4%">
									<s:if test="#o.state==1">
									    <a
										href="${ pageContext.request.contextPath }/AdminOrder_delete.action?oid=<s:property value="#o.oid"/>&page=<s:property value="pageBean.page" />">
											<img
											src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									    </a>
									</s:if>
									<s:elseif test="#o.state==4">
									<a
										href="${ pageContext.request.contextPath }/AdminOrder_delete.action?oid=<s:property value="#o.oid"/>&page=<s:property value="pageBean.page" />">
											<img
											src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
									</s:elseif>			
									</td>
								</tr>

							</s:iterator>
						</table>
					</td>
				</tr>
				<tr align="center">
					<td colspan="7">第<s:property value="pageBean.page" />/<s:property
							value="pageBean.totalPage" />页 <s:if test="pageBean.page != 1">
							<a
								href="${pageContext.request.contextPath}/AdminOrder_findallOrder.action?page=1">首页</a>|
								<a
								href="${pageContext.request.contextPath}/AdminOrder_findallOrder.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
							</s:if> <s:if test="pageBean.page != pageBean.totalPage">
							<a
								href="${pageContext.request.contextPath}/AdminOrder_findallOrder.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
								<a
								href="${pageContext.request.contextPath}/AdminOrder_findallOrder.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>|
							</s:if>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

