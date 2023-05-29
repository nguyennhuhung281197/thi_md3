<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/29/2023
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/staff?action=staff">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New User</h2>
            </caption>
            <tr>
                <th>Id:</th>
                <td>
                    <input type="text" name="name" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>address:</th>
                <td>
                    <input type="text" name="address" id="address" size="15"/>
                </td>
            </tr>
            <tr>
                <th>phone number:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="15"/>
                </td>
            </tr>
            <tr>
                <th>salary :</th>
                <td>
                    <input type="text" name="salary" id="salary" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Department:</th>
                <td>
                    <input type="text" name="department" id="department" size="15"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
