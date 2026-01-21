<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Registration Form</h2>
<form action="<%=request.getContextPath()%>/StudentServlet">
<table>

<tr>
    <td>User Id</td>
    <td>
        <input type="text" name="userid"
               required
               pattern=".{5,12}"
               title="User ID must be 5 to 12 characters">
    </td>
</tr>

<tr>
    <td>Password</td>
    <td>
        <input type="password" name="password"
               required
               pattern=".{7,12}"
               title="Password must be 7 to 12 characters">
    </td>
</tr>

<tr>
    <td>Name</td>
    <td>
        <input type="text" name="name"
               required
               pattern="[A-Za-z]+"
               title="Name must contain alphabets only">
    </td>
</tr>

<tr>
    <td>Address</td>
    <td>
        <input type="text" name="address">
    </td>
</tr>

<tr>
    <td>Country</td>
    <td>
        <select name="country" required>
            <option value="">--Select Country--</option>
            <option value="India">India</option>
            <option value="Canada">Canada</option>
            <option value="USA">USA</option>
        </select>
    </td>
</tr>

<tr>
    <td>ZIP Code</td>
    <td>
        <input type="text" name="zip"
               required
               pattern="[0-9]+"
               title="ZIP code must be numeric">
    </td>
</tr>

<tr>
    <td>Email</td>
    <td>
        <input type="email" name="email" required>
    </td>
</tr>

<tr>
    <td>Sex</td>
    <td>
        <input type="radio" name="sex" value="Male" required> Male
        <input type="radio" name="sex" value="Female"> Female
    </td>
</tr>

<tr>
    <td>Language</td>
    <td>
        <input type="checkbox" name="lang" value="English" required> English
        <input type="checkbox" name="lang" value="Non-English"> Non-English
    </td>
</tr>

<tr>
    <td>About</td>
    <td>
        <textarea name="about" rows="5" cols="30"></textarea>
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