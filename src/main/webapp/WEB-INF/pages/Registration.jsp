<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registration</title>
<!-- <link rel="stylesheet" type="text/css" href="theme/style.css" /> -->
<!-- <script type="text/javascript" src="js/checkRegistrationForm.js"></script> -->
</head>
<body>
	<div>
		<h1>Time Journal: Registration</h1>
		<hr />

		<form:form action="register.action" commandName="userDTO">
			<table>
				<tr>
					<td>First name:</td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" class="errorMsg" /></td>
				</tr>

				<tr>
					<td>Last name:</td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" class="errorMsg" /></td>
				</tr>

				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" class="errorMsg" /></td>
				</tr>

				<tr>
					<td>Login:</td>
					<td><form:input path="login" /></td>
					<td><form:errors path="login" class="errorMsg" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" class="errorMsg" /></td>
				</tr>
<!-- 
				<tr>
					<td colspan="2" id="passwordWarning">6 characters minimum</td>
				</tr>
 -->
 				<tr>
					<td>Re-enter password:</td>
					<td><form:password path="confirmedPassword" /></td>
					<td><form:errors path="confirmedPassword" class="errorMsg" /></td>
				</tr> 

				<tr></tr>

				<tr>
					<td><form:button type="submit">Register</form:button></td>
					<td><form:button type="reset">Reset</form:button></td>
				</tr>

				<tr>
					<td align="center" colspan="2"><a href="logout.action" name="return">Login page</a></td>
				</tr>

				<tr></tr>
	
<%-- 				<tr>
					<td colspan="2" class="errorMsg">${requestScope.errorMsg}</td>
				</tr> --%>
			</table>
		</form:form>
	</div>
</body>
</html>