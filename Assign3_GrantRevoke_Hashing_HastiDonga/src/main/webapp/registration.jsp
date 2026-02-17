<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registration</title>
</head>
<body>
  <h2>Registration</h2>

  <form action="<%=request.getContextPath()%>/register" method="post">
    <label>Username:</label>
    <input type="text" name="username" required><br><br>

    <label>Password:</label>
    <input type="password" name="password" required><br><br>

    <label>Mobile:</label>
    <input type="text" name="mobile"><br><br>

    <label>Email:</label>
    <input type="email" name="email"><br><br>

    <button type="submit">Submit</button>
  </form>

  <br>
  <a href="users.jsp">View Users</a>

  <p style="color:red;">
    <%= request.getAttribute("msg") == null ? "" : request.getAttribute("msg") %>
  </p>
</body>
</html>
