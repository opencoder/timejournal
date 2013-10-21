<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>The Best Time Journal</title>
<link rel="stylesheet" type="text/css" href="theme/style.css" />
</head>
<body>


	<div>
		<h1>Time Journal</h1>
		<hr />
		<form action="signIn.action" method="post">
			<table>

				<tr>
					<td>Login:</td>
					<td><input type="text" name="login" /></td>
					<td><input type="submit" value="Sign In" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
					<td></td>
					<td align="right"><a href="registration.action"
						name="register">Registration</a></td>
				</tr>
				<%-- 				<tr>
					<td colspan="4" class="errorMsg">${requestScope.errorMsg}</td>
				</tr> --%>
			</table>
		</form>
	</div>
</body>
</html>