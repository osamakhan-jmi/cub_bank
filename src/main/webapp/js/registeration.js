function register() {

    var cid = $('#id').val();
    var mobno = $('#mobno'). val();
    var cstFname = $('#cstFname'). val();
    var cstMname = $('#cstMname'). val()
    var cstLname = $('#cstLname'). val();
    var gender = $('#gender'). val();
    var email = $('#email'). val();
    var street = $('#street').val();
    var city = $('#street'). val();
    var state = $('#state'). val();
    var country = $('#country'). val();
    var pin = $('#pin'). val();
    var mpin = $('#mpin'). val();
    var pswd = $('#pswd'). val();
    var cpswd = $('#cpswd'). val();

    if(cid==""||mobno==""||cstFname==""||cstMname==""||cstLname==""||gender==""||email==""
    ||street==""||city==""||state==""||country==""||pin==""||mpin==""||pswd==""||cpswd=="")
        alert(" * Requierd");
    else if(/^\d{10}$/.test(mobno)&&/^\d{7}$/.test(pin)){
        $.ajax({
            url: "/cubbank/customer/register",
            data: {
                "id": cid,
                "mobno": mobno,
                "cstFname": cstFname,
                "cstMname": cstMname,
                "cstLname": cstLname,
                "gender": gender,
                "email": email,
                "street": street,
                "state": state,
                "city": city,
                "country": country,
                "pin": pin,
                "mpin": mpin,
                "pswd": pswd,
                "cpswd": cpswd
            },
            type: "POST",
            success: function (data) {
                alert("You Are Successfully Registered");
                console.log("SUCCESS : ", data);
            },
            error: function (e) {
                alert("Registration Failed");
                console.log("ERROR : ", e);
            }
        });
    }
}
