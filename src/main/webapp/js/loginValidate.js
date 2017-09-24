function login() {
	var id = $("#userid").val();
	var pswd = $("#password").val();
    if(id==""||pswd=="")
        alert("all entries required!!");
    else{
        $.ajax({
            url:"/cubbank/login",
            type:"POST",
            data:{"userid":id,"password":pswd},
            success: function(data){
                console.log(data);
            },
            error:function(e){
                console.log(e);
            }
        });
    }
}