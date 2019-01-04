<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/AdminVersion_update.action?page=<s:property value="page"/>" method="post" enctype="multipart/form-data">
			<input type="hidden" name="vid" value="<s:property value="version.vid"/>">
			<input type="hidden" name="vimg" value="<s:property value="version.vimg"/>">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑手机型号</STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						手机型号名称：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<input type="text" name="vname" value="<s:property value="version.vname"/>" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01" rowspan="6">
						所属的手机品牌：
					</td>
					<td class="ta_01" bgColor="#ffffff" rowspan="6">
						<select name="brand.bid">
							<s:iterator var="c" value="bList">
								<option value="<s:property value="#c.bid"/>" <s:if test="#c.bid==version.brand.bid">selected</s:if>><s:property value="#c.bname"/></option>
							</s:iterator>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<input type="text" name="vdesc" value="<s:property value="version.vdesc"/>" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="2"/>
					</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						价格：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<input type="text" name="vprice" value="<s:property value="version.vprice"/>" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="2"/>
					</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
					<input type="file" name="upload" />
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="2"/>
					</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						热门机型：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<input type="text" name="is_hot" value="<s:property value="version.is_hot"/>" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="2"/>
					</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						上架状态：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<input type="text" name="vstate" value="<s:property value="version.vstate"/>" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="2"/>
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
		<strong>*上架状态： 0 ：取消上架 &nbsp;&nbsp; 1 ：确定上架 </strong><br>
		<strong>*热门机型： 0 ： 不是  &nbsp;&nbsp; 1： 是</strong>
	</body>
</HTML>