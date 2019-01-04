<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/AdminBrand_update.action" method="post" enctype="multipart/form-data">
			<input type="hidden" name="bid" value="<s:property value="fbrand.bid"/>"/>
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑手机品牌</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						手机品牌名称：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="text" name="bname" value="<s:property value="fbrand.bname"/>" id="userAction_save_do_logonName" class="bg"/>						
						</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_02">
						上架状态：
					</td>
					<td class="ta_02" bgColor="#ffffff" colspan="3">
						<input type="text" name="bstate" value="<s:property value="fbrand.bstate"/>" id="userAction_save_do_logonName" class="bg"/>						
						</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>