<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
  <form action="/getempbyId" method="post">
 Enter Id: <input type="number" name="id" required/>
 <button type="submit">fetch Emp</button>
 </form>

<br><br>

<c:if test="${emp != null}">
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Role</th>
        <th>Salary</th>
          <th>Actions</th>
    </tr>
    <tr>
        <td>${emp.id}</td>
        <td>${emp.name}</td>
        <td>${emp.role}</td>
        <td>${emp.salary}</td>
    <td>
    <button type="button"
            onclick="window.location.href='updateempbyId?id=${emp.id}'">
        Update
    </button>
</td>

    </tr>
    
</table>
</c:if>

<c:if test="${emp == null}">
    <p style="color:red;">Employee not found</p>
</c:if>

</body>
</html>
 