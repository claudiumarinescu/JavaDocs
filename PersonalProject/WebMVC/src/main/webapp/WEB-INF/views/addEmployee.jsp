<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<br/><br/>
<div class="container" align="center" style="width: 50%; text-align: center; font-size: medium">
    <form:form action="/employees/save" method="POST" modelAttribute="employee">
        <form:hidden path="id"/>
        <div class="form-horizontal">
            <div class="form-group">
                <label for="firstName" class="col-sm-2 control-label">FirstName:</label>
                <div class="col-sm-10">
                    <form:input id="firstName" path="firstName" required="required" cssStyle="width: 90%"/>
                </div>
            </div>
            <div class="form-group">
                <label for="lastName" class="col-sm-2 control-label">Last Name:</label>
                <div class="col-sm-10">
                    <form:input id="lastName" path="lastName" required="required" cssStyle="width: 90%"/>
                </div>
            </div>
            <div class="form-group">
                <label for="jobInput" class="col-sm-2 control-label">Job:</label>
                <div class="col-sm-10">
                    <select name="jobID" id="jobInput" style="width: 90%">
                        <c:forEach items="${jobs}" var="job">
                            <option value="${job.id}">${job.title}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="managerInput" class="col-sm-2 control-label">Manager:</label>
                <div class="col-sm-10">
                    <select name="managerID" id="managerInput" style="width: 90%">
                        <c:forEach items="${employees}" var="emp">
                            <option value="${emp.id}">${emp.firstName} ${emp.lastName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="hireDate" class="col-sm-2 control-label">Hire Date:</label>
                <div class="col-sm-10">
                    <form:input id="hireDate" path="hireDate" required="required" cssStyle="width: 90%"/>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-offset-2 col-sm-10">
                    <div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="reset" class="btn btn-primary">Reset</button>
                        <button type="button"  class="btn btn-primary" onclick='location.href="/employees/list"'>Back</button>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
