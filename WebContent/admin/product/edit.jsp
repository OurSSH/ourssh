<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/Style1.css"
	type="text/css" rel="stylesheet">
</HEAD>

<body>
	<!--  -->
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/AdminProduct_update.action?page=<s:property value="page"/>"
		method="post">
		<input type="hidden" name="pid" value="<s:property value="product.pid"/>">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>修改商品</STRONG> </strong></td>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					配置：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="pdesc" value="<s:property value="product.pdesc"/>" id="userAction_save_do_logonName" class="bg"/>
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01" rowspan="3">
					所属的手机型号：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3" rowspan="3"><select name="version.vid">
							<s:iterator var="v" value="list">
								<option value="<s:property value="#v.vid"/>" <s:if test="#v.vid == product.version.vid">selected</s:if>><s:property value="#v.vname"/></option>
							</s:iterator>
						</select></td>
				</tr>
				<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					售价：</td>
				<td class="ta_01" bgColor="#ffffff">
				<input type="text"
					name="pprice" value="<s:property value="product.pprice"/>" id="userAction_save_do_logonName" class="bg" />
			</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					库存：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="pstock" value="<s:property value="product.pstock"/>" id="userAction_save_do_logonName"
					class="bg" /></td>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<button type="submit" id="userAction_save_do_submit" value="确定"
						class="button_ok">&#30830;&#23450;</button> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>