/**
 * Created by Claudiu.Marinescu on 7/21/2017.
 */
var employeeActions = function() {

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/employees/actions", false ); // false for synchronous request
    xmlHttp.send();
    document.getElementById('additionalButtons').innerHTML = xmlHttp.responseText;
    return xmlHttp.responseText;

}

var jobActions = function() {

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/jobs/actions", false ); // false for synchronous request
    xmlHttp.send();
    document.getElementById('additionalButtons').innerHTML = xmlHttp.responseText;
    return xmlHttp.responseText;

}

var projectActions = function() {

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/projects/actions", false ); // false for synchronous request
    xmlHttp.send();
    document.getElementById('additionalButtons').innerHTML = xmlHttp.responseText;
    return xmlHttp.responseText;

}

var taskActions = function() {

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/tasks/actions", false ); // false for synchronous request
    xmlHttp.send();
    document.getElementById('additionalButtons').innerHTML = xmlHttp.responseText;
    return xmlHttp.responseText;

}

var getAllEmployees = function() {
    window.location.href = "/employees/list";
}

var addEmployee = function() {
    window.location.href = "/employees/add";
}