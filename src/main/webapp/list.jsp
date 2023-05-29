<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/29/2023
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" cellpadding="5">
    <caption><h2>List of Users</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>PhoneNumber</th>
        <th>salary</th>
        <th>Department</th>
    </tr>
    <c:forEach var="staff" items="${staff}">
        <tr>
            <td><c:out value="${staff.staffId}"/></td>
            <td><c:out value="${staff.staffName}"/></td>
            <td><c:out value="${staff.staffEmail}"/></td>
            <td><c:out value="${staff.staffAddress}"/></td>
            <td><c:out value="${staff.phoneNumber}"/></td>
            <td><c:out value="${staff.salary}"/></td>
            <td><c:out value="${staff.department}"/></td>
            <td>
                <a href="/staff?action=edit&id=${staff.id}">Edit</a>
                <a href="/staff?action=delete&id=${staff.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
