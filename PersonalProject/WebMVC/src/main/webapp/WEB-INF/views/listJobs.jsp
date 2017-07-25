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
<body style="background-color: ghostwhite">
<nav class="navbar navbar-inverse bg-inverse" role="navigation">
    <div class="container-fluid navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand">PM App</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li><a href="/">Home</a></li>
            <li><a href="/employees">Employees</a></li>
            <li><a href="/jobs">Jobs</a></li>
            <li><a href="/projects">Projects</a></li>
        </ul>
    </div>
</nav>
<div align="center">
<div style="margin: 5%; width: 50%">
    <div class="table-responsive">
        <table class="table table-hover table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Job Title</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody id="tableBody">
                <c:forEach items="${jobs}" var="job">
                    <tr>
                        <td>${job.id}</td>
                        <td>${job.title}</td>
                        <td>
                            <a href="/jobs/delete/${job.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div align="center">
    <button class="btn btn-primary" onclick='location.href="/jobs/add"'>Add</button>
</div>
</div>
<script type="text/javascript" src="../../js/controller.js"></script>
</body>
</html>