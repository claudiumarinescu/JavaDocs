
var employeeActions = function() {

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/employees/actions", false ); // false for synchronous request
    xmlHttp.send();
    document.getElementById('additionalButtons').innerHTML = xmlHttp.responseText;
    return xmlHttp.responseText;

}

var goToEmployees = function() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/employees/list", false ); // false for synchronous request
    xmlHttp.send();
    document.getElementById('additionalHTML').innerHTML = xmlHttp.responseText;
    return xmlHttp.responseText;
}