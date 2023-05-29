<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/29/2023
  Time: 11:24 AM
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
    <a href="users?action=users">List All Users</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Edit User
        </h2>
      </caption>
      <c:if test="${staff != null}">
        <input type="hidden" name="id" value="<c:out value='${staff.staffId}' />"/>
      </c:if>
      <tr>
        <th>User Name:</th>
        <td>
          <input type="text" name="name" size="45"
                 value="<c:out value='${staff.staffName}' />"
          />
        </td>
      </tr>
      <tr>
        <th>User Email:</th>
        <td>
          <input type="text" name="email" size="45"
                 value="<c:out value='${staff.staffEmail}' />"
          />
        </td>
      </tr>
      <tr>
        <th>address:</th>
        <td>
          <input type="text" name="address" size="15"
                 value="<c:out value='${staff.staffAddress}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Phone number:</th>
        <td>
          <input type="text" name="phoneNumber" size="15"
                 value="<c:out value='${staff.phoneNumber}' />"
          />
        </td>
      </tr>
      <tr>
        <th>salary :</th>
        <td>
          <input type="text" name="salary" size="15"
                 value="<c:out value='${staff.salary}' />"
          />
        </td>
      </tr>
      <tr>
        <th>department:</th>
        <td>
          <input type="text" name="department" size="15"
                 value="<c:out value='${staff.department}' />"
          />
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
