<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Servlet Starter</title>
</head>

<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<h1>We are getting Started with Servlets</h1>
<!-- <a href="first">Go to Servlet</a> -->
<form action="first" method="post">
    <input type="text" name="userName" placeholder="Your Name"><br>
    <input type="password" name="userPass" placeholder="Your password">
    <input type="text" name="userAddress" placeholder="Your Address">
    <input type="submit" value="NEXT">

</form>
</body>
</html>