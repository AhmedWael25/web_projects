$(document).ready(function(){

    var request2 = null;
    setInterval(function(){

        if(window.XMLHttpRequest)
            request2 = new XMLHttpRequest();
        else if(window.ActiveXObject)
            request2 = new ActiveXObject(Microsoft.XMLHTTP);
    
        request2.onreadystatechange = handleGetJsonData;
        request2.open("GET", "chat", true);
        request2.send(null);
    },1000);

    function handleGetJsonData(){
        if(request2.readyState == 4 && request2.status == 200){
            generateChat(request2.responseText);
        }
    }
});

function generateChat(data){

    console.log(data);
    var myMessages = JSON.parse(data);
    console.log(myMessages);
    var table = $("#messagesBody");
    table.html("");
    console.log(myMessages.length);
    for(var i = 0 ; i < myMessages.length; i++){

        table.append("<tr id='"+myMessages[i].id+"'><td>"+myMessages[i].name+"</td> <td>"+myMessages[i].msg+"</td></tr>");

    }

}



function sendMsg(){


    var name = $("#nameInput").val();
    var msg = $("#messageInput").val();

    if(name == "" || msg == "") return;

    var myMsgObject = new Object();
    myMsgObject.name = name;
    myMsgObject.msg = msg;
    var jsonData = JSON.stringify(myMsgObject);

    $("#nameInput").val("");
    $("#messageInput").val("");
    $.ajax(
        {
            url:"chat",
            type:"POST",
            data:myMsgObject,
            dataType:"json",
            success:function(data){
                console.log(data);
            }
        }
    );

}