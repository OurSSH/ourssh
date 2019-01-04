<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8" import="java.util.*,ssh.vo.Brand"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function addCategorySecond(){
				window.location.href = "${pageContext.request.contextPath}/AdminVersion_addPage.action?page=<s:property value="pageBean.page"/>";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/version/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>手机型号列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addCategorySecond()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="7%">
										序号
									</td>
									<td align="center" width="7%">
										手机型号
									</td>
									<td align="center" width="7%">
										描述
									</td>
									<td align="center" width="7%">
										价格
									</td>
									<td align="center" width="7%">
										图片
									</td>
									<td align="center" width="5%">
										所属品牌
									</td>
									<td align="center" width="5%">
										热门机型
									</td>
									<td align="center" width="5%">
										上架状态
									</td>
									<td width="5%" align="center">
										编辑
									</td>
<!-- 									<td width="5%" align="center"> -->
<!-- 										删除 -->
<!-- 									</td> -->
								</tr>
							
								
									<s:iterator var="cs" value="pageBean.list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#cs.vname"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#cs.vdesc"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#cs.vprice"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<img width="40" height="45" src="${ pageContext.request.contextPath }/<s:property value="#cs.vimg"/>">
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#cs.brand.bname"/>
<!-- 												 i++; -->
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#cs.is_hot"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#cs.vstate"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/AdminVersion_edit.action?vid=<s:property value="#cs.vid"/>&page=<s:property value="pageBean.page"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
<!-- 											<td align="center" style="HEIGHT: 22px"> -->
<%-- 												<a href="${ pageContext.request.contextPath }/adminCategorySecond_delete.action?vid=<s:property value="#cs.vid"/>"> --%>
<%-- 													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand"> --%>
<!-- 												</a> -->
<!-- 											</td> -->
										</tr>
									</s:iterator>	
							</table>
						</td>
						
					</tr>
					<tr align="center">
						<td colspan="4">
							第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页  
							<s:if test="pageBean.page != 1">
								<a href="${pageContext.request.contextPath}/AdminVersion_findallVersion.action?page=1">首页</a> |
								<a href="${pageContext.request.contextPath}/AdminVersion_findallVersion.action?page=<s:property value="pageBean.page-1"/>">上一页</a> |
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
							<a href="${pageContext.request.contextPath}/AdminVersion_findallVersion.action?page=<s:property value="pageBean.page+1"/>">下一页</a> |
							<a href="${pageContext.request.contextPath}/AdminVersion_findallVersion.action?page=<s:property value="pageBean.totalPage"/>">尾页</a> 
							</s:if>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
		<strong>*上架状态： 0 ：取消上架 &nbsp;&nbsp; 1 ：确定上架 </strong><br>
		<strong>*热门机型： 0 ： 不是  &nbsp;&nbsp; 1： 是</strong>
	</body>
</HTML>

