<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>PM Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<h1 align="center">List of Employees</h1>
<div align="center" style="margin: 50px">
    <div class="table-responsive">
        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Job ID</th>
                    <th>Manager ID</th>
                    <th>Hire Date</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody id="tableBody">
                <c:forEach items="${list}" var="employee">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.job}</td>
                        <td>${employee.manager}</td>
                        <td>${employee.hireDate}</td>
                        <td>
                            <a href="/employees/delete/${employee.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div align="center">
    <button class="btn btn-success" onclick='window.location.href = "/"'>Home</button>
</div>

<script type="text/javascript" src="../../js/controller.js"></script>
</body>
</html>