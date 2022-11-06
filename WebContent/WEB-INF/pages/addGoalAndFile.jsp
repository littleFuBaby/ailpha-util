<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Own</title>
</head>
<body>
	<%
		String url = request.getContextPath() + "/goal/addGoalAndFile";
	%>
	<form action="<%=url %>" method="post" enctype="multipart/form-data">
		<table align="center" bgcolor="" background="">
			<tbody align="center" valign="middle">
				<tr>
					<td align="left">名稱</td>
					<td align="left"><input name="name" type="text" value=""/></td>
				</tr>
				<tr>
					<td align="left">文件</td>
					<td align="left"><input name="file" type="file"/></td>
				</tr>
				<tr>
					<td colspan="2"><input name="submit" type="submit" value="提交"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>