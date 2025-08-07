<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="account/signin" method="POST">
		<div class="container">
			<h1>Log In</h1>
			<p>Please login credential.</p>
			<hr>
			
			
			<label for="email"><b>Email</b></label> 
			<input type="text" placeholder="Enter Email" name="email" id="email" required>
			<br>
			<br>
			
			<label for="psw"><b>Password</b></label> 
			<input type="password"	placeholder="Enter Password" name="psw" id="psw" required>
			<hr>

			<input type="submit" value="Sign In">
		</div>
	</form>
</body>
</html>