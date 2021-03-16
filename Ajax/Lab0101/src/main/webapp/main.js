window.onload = function(){
    initTableGet();
}

var request1 = null;
var request2 = null;
var request3 = null;
function getText(){

  
    if(window.XMLHttpRequest)
        request1 = new XMLHttpRequest();
    else if(window.ActiveXObject)
        request1 = new ActiveXObject(Microsoft.XMLHTTP);

    request1.onreadystatechange = handleGetTextRequest;
    request1.open("GET", "fromserv.txt?t="+new Date().getTime(), true);
    request1.send(null);
}

function handleGetTextRequest(){
    if(request1.readyState == 4){

        if(request1.status == 200){
            document.txtAjax.textInput.value ="GOT : "+ request1.responseText;
        }else{
            document1.txtAjax.textInput.value = "Error Code: " + request1.status;
        }

    }
}

function initTableGet(){
    setInterval(function(){

        if(window.XMLHttpRequest)
            request2 = new XMLHttpRequest();
        else if(window.ActiveXObject)
            request2 = new ActiveXObject(Microsoft.XMLHTTP);
    
        request2.onreadystatechange = handleGetTableRequest;
        request2.open("GET", "table.txt", true);
        request2.send(null);
    },4000);
}

function handleGetTableRequest(){
    if(request2.readyState == 4){
        if(request2.status == 200){
            document.getElementById("table").innerHTML = request2.responseText;
        }else{
            document.getElementById("table").innerHTML = "<p>Error Getting from Server</p>";
        }
    }
}


function checkUsernameValidity(){
    if(window.XMLHttpRequest)
        request3 = new XMLHttpRequest();
    else if(window.ActiveXObject)
        request3 = new ActiveXObject(Microsoft.XMLHTTP);


    request3.onreadystatechange = handleValidityCheck;

    var username = document.getElementById("usernameInput").value;
    if(username == "") return;
    url = "validate?timeStamp="+new Date().getTime();
    request3.open("POST",url,true);
    request3.setRequestHeader("content-type", "application/x-www-form-urlencoded");

    request3.send("username="+username);
}

function handleValidityCheck(){
    if(request3.readyState == 4 && request3.status == 200){
        var resp = request3.responseText;
        document.getElementById("usernameHelp").textContent = resp;
    }
}



