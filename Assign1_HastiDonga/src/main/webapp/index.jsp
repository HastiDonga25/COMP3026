<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>

<style>
    .error {
        color: red;
        font-size: 13px;
    }
</style>

</head>
<body>

<h2>Registration Form</h2>

<!-- 🔴 General DB error -->
<div class="error">
<%= request.getAttribute("generalErr") != null ? request.getAttribute("generalErr") : "" %>
</div>

<form action="<%=request.getContextPath()%>/RegisterServlet" method="post">
<table>

<tr>
    <td>User Id</td>
    <td>
        <input type="text" name="userid"
               value="<%= request.getAttribute("form_userid") != null ? request.getAttribute("form_userid") : "" %>"
               required pattern=".{5,12}"
               title="User ID must be 5 to 12 characters">
        <div class="error">
            <%= request.getAttribute("uidErrServer") != null ? request.getAttribute("uidErrServer") : "" %>
        </div>
    </td>
</tr>

<tr>
    <td>Password</td>
    <td>
        <input type="password" name="password"
               required pattern=".{7,12}"
               title="Password must be 7 to 12 characters">
    </td>
</tr>

<tr>
    <td>Name</td>
    <td>
        <input type="text" name="name"
               value="<%= request.getAttribute("form_name") != null ? request.getAttribute("form_name") : "" %>"
               required pattern="[A-Za-z]+"
               title="Name must contain alphabets only">
    </td>
</tr>

<tr>
    <td>Address</td>
    <td>
        <input type="text" name="address"
               value="<%= request.getAttribute("form_address") != null ? request.getAttribute("form_address") : "" %>">
    </td>
</tr>

<tr>
    <td>Country</td>
    <td>
        <select name="country" required>
            <option value="">--Select Country--</option>
            <option value="India" <%= "India".equals(request.getAttribute("form_country")) ? "selected" : "" %>>India</option>
            <option value="Canada" <%= "Canada".equals(request.getAttribute("form_country")) ? "selected" : "" %>>Canada</option>
            <option value="USA" <%= "USA".equals(request.getAttribute("form_country")) ? "selected" : "" %>>USA</option>
        </select>
    </td>
</tr>

<tr>
    <td>ZIP Code</td>
    <td>
        <input type="text" name="zip"
               value="<%= request.getAttribute("form_zip") != null ? request.getAttribute("form_zip") : "" %>"
               required pattern="[0-9]+"
               title="ZIP code must be numeric">
    </td>
</tr>

<tr>
    <td>Email</td>
    <td>
        <input type="email" name="email"
               value="<%= request.getAttribute("form_email") != null ? request.getAttribute("form_email") : "" %>"
               required>
        <div class="error">
            <%= request.getAttribute("emailErrServer") != null ? request.getAttribute("emailErrServer") : "" %>
        </div>
    </td>
</tr>

<tr>
    <td>Sex</td>
    <td>
        <input type="radio" name="sex" value="Male"
            <%= "Male".equals(request.getAttribute("form_sex")) ? "checked" : "" %> required> Male
        <input type="radio" name="sex" value="Female"
            <%= "Female".equals(request.getAttribute("form_sex")) ? "checked" : "" %>> Female
    </td>
</tr>

<tr>
    <td>Language</td>
    <td>
        <input type="checkbox" name="lang" value="English"> English
        <input type="checkbox" name="lang" value="Non-English"> Non-English
    </td>
</tr>

<tr>
    <td>About</td>
    <td>
        <textarea name="about" rows="5" cols="30"><%= request.getAttribute("form_about") != null ? request.getAttribute("form_about") : "" %></textarea>
    </td>
</tr>

<tr>
    <td colspan="2" align="center">
        <input type="submit" value="Submit">
    </td>
</tr>

</table>
</form>

</body>
</html>
