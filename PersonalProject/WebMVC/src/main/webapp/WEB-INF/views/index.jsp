<html>
<head>
    <title>PM Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>

    <div class="jumbotron" align="center" style="margin: 50px">
        <h1 style="color: #550000; font-family: 'Droid Sans'">Welcome!</h1>
        <h2>Choose one of the following:</h2>

        <div>
            <button class="btn btn-success" onclick="employeeActions()">Employees</button>
            <button class="btn btn-success" onclick="jobActions()">Jobs</button>
            <button class="btn btn-success" onclick="projectActions()">Projects</button>
            <button class="btn btn-success" onclick="taskActions()">Tasks</button>
        </div>

        <br>
        <div id="additionalButtons"></div>

    </div>

<script type="text/javascript" src="../../js/controller.js"></script>
</body>
</html>
