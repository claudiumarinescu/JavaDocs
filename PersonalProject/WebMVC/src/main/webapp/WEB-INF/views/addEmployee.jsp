<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>PM Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>

<div align="center" >
<div class="panel panel-default" style="margin: 50px; align-self: center; width: 70%">
    <div class="panel-heading" align="center">
        <h2 class="panel-title">Add employee</h2>
    </div>
    <div class="panel-body" align="left">

        <form:form action="/employee/save" method="POST" modelAttribute="employeeForm">
            <form:hidden path="id"/>
            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="firstName">First Name:</label>
                        <form:input id="firstName" path="firstName"/>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="lastName">Last Name:</label>
                        <form:input id="lastName" path="lastName"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="jobId">Job:</label>
                        <form:input id="jobId" path="job"/>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="managerId">Manager:</label>
                        <form:input id="managerId" path="manager"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="hireDate">Hire Date:</label>
                        <form:input id="hireDate" path="hireDate"/>
                    </div>
                </div>
            </div>
            <br>
            <div class="row" align="center">
                <div class="container-fluid">
                    <div>
                        <button type="submit" class="btn btn-default" >Save</button>
                        <button class="btn btn-default" >Reset</button>
                        <button class="btn btn-default" >Back</button>
                    </div>
                </div>
            </div>
        </form:form>

    </div>
</div>
</div>

<script type="text/javascript" src="bower_components/jquery/jquery.js"></script>
<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
</body>
</html>
