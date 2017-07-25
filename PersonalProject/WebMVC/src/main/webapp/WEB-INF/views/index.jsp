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

    <div class="jumbotron" align="center" style="margin: 50px">
        <h1 style="color: #550000; font-family: 'Droid Sans'">Welcome!</h1>
        <h2>Pick a category</h2>

        <%--<div>--%>
            <%--<button class="btn btn-success" onclick='location.href="/employees/list"'>Employees</button>--%>
            <%--<button class="btn btn-success" onclick='location.href="/jobs/list"'>Jobs</button>--%>
            <%--<button class="btn btn-success" onclick='location.href="/projects/list"'>Projects</button>--%>
            <%--<button class="btn btn-success" onclick='location.href="/tasks/list"'>Tasks</button>--%>
        <%--</div>--%>
        <%--<div>--%>
            <%--<button class="btn btn-success" onclick='location.href="/employees/list"'>Employees</button>--%>
            <%--<button class="btn btn-success" onclick='location.href="/jobs/list"'>Jobs</button>--%>
            <%--<button class="btn btn-success" onclick='location.href="/projects/list"'>Projects</button>--%>
            <%--<button class="btn btn-success" onclick='location.href="/tasks/list"'>Tasks</button>--%>
        <%--</div>--%>

        <br>
        <div id="additionalHTML"></div>

    </div>

<script type="text/javascript" src="../../js/controller.js"></script>
</body>
</html>
