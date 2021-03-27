var i = 0;

function sum() {
    var sum = 0;
    for(var i = 0 ; i < 1000000 ; i++){
        sum = sum + i;
    }
    postMessage(sum);
}



function userPost(userJson){

    postMessage("from worker: "+userJson);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "chat", true);
    xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

    xhr.send("user="+userJson);
}


self.addEventListener("message", function(e) {
    var jsonUser = e.data.user
    userPost(jsonUser);
});

sum();