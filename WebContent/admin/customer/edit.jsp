<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${ pageContext.request.contextPath }/AdminCustomer_update.action?page=<s:property value="page" />&key=<s:property value="key"/>&value=<s:property value="value"/>" method="post" >
		<!-- 			传入隐藏id -->
		<input type="hidden" name="uid" value="<s:property value="user.uid"/>" />
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑用户</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						用户名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="username" value="<s:property value="user.username"/>" id="userAction_save_do_logonName" class="bg" readonly="readonly"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						密码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="password" value="<s:property value="user.password"/>" id="userAction_save_do_logonName" class="bg" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						姓名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="name" value="<s:property value="user.name"/>" id="userAction_save_do_logonName" class="bg" readonly="readonly"/>
						</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						邮箱：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="email" value="<s:property value="user.email"/>" id="userAction_save_do_logonName" class="bg" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						电话：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="phone" value="<s:property value="user.phone"/>" id="userAction_save_do_logonName" class="bg" readonly="readonly"/>
						</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						地址：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="addr" value="<s:property value="user.addr"/>" id="userAction_save_do_logonName" class="bg" readonly="readonly"/>
					</td>		
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						激活状态：
					</td>
					<td class="ta_01" bgColor="#ffffff">
<%-- 						<input type="text" name="phone" value="<s:property value="model.phone"/>" id="userAction_save_do_logonName" class="bg"/> --%>
							<select name="state">
							<option value="0" <s:if test="user.state==0">selected</s:if>>0</option>
							<option value="1" <s:if test="user.state==1">selected</s:if>>1</option>
						</select>&nbsp;&nbsp;<span>*激活状态   &nbsp;&nbsp;0：未激活  &nbsp;&nbsp;  1：激活</span>
						</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						激活码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="code" value="<s:property value="user.code"/>" id="userAction_save_do_logonName" class="bg" readonly="readonly"/>
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