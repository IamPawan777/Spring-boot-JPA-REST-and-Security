<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
	<form action="account/signup" method="POST">
		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>
			
			<label for="username"><b>Name</b></label> 
			<input type="text" placeholder="Enter Username" name="username" id="username" required>
			<br>
			<br>
			
			<label for="email"><b>Email</b></label> 
			<input type="text" placeholder="Enter Email" name="email" id="email" required>
			<br>
			<br>
			
			<label for="psw"><b>Password</b></label> 
			<input type="password"	placeholder="Enter Password" name="psw" id="psw" required>
			<hr>

			<input type="submit" value="Sign Up">
		</div>
	</form>
	
</body>
</html>