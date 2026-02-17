<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, com.assign3.model.User" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Users</title>
</head>
<body>
  <h2>Saved Users</h2>
  <a href="registration.jsp">Back to Registration</a>
  <br><br>

  <%
    List<User> users = (List<User>) request.getAttribute("users");
    if (users == null || users.isEmpty()) {
  %>
      <p>No users found.</p>
  <%
    } else {
  %>
    <table border="1" cellpadding="8">
      <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password Hash</th>
        <th>Mobile</th>
        <th>Email</th>
      </tr>
      <% for (User u : users) { %>
      <tr>
        <td><%= u.getId() %></td>
        <td><%= u.getUsername() %></td>
        <td><%= u.getPasswordHash() %></td>
        <td><%= u.getMobile() %></td>
        <td><%= u.getEmail() %></td>
      </tr>
      <% } %>
    </table>
  <%
    }
  %>
</body>
</html>
    