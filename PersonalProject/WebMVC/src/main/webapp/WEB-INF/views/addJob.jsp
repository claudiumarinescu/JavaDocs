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


<div align="center" >
    <div class="container" align="center" style="width: 50%; text-align: center; font-size: medium; margin: 5%">
        <form:form action="/jobs/save" method="POST" modelAttribute="job">
            <form:hidden path="id"/>
            <div class="form-horizontal">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-label">Job Title:</label>
                    <div class="col-sm-10">
                        <form:input id="title" path="title" required="required" cssStyle="width: 90%"/>
                    </div>
                </div>
            </div>
            <br/>
            <div class="row" align="center">
                <div class="container-fluid">
                    <div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="reset" class="btn btn-primary" >Reset</button>
                        <button type="button"  class="btn btn-primary" onclick='location.href="/jobs/list"'>Back</button>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>
