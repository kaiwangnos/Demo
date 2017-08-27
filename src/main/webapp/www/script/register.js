$(document).ready(function () {
    //点击按钮
    $("#register").click(function () {
        register();
    });


});


function register() {
    var url = "http://localhost:8080/demo/register";
    var userId = document.getElementById("userId").value;
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    var password1 = document.getElementById("password1").value;
    var sex = document.getElementById("sex").value;
    var age = document.getElementById("age").value;
    var phone = document.getElementById("phone").value;
    var mail = document.getElementById("mail").value;
    var result;

    if(password != password1){
        $("#message").text("两次输入的密码不一致");
        return;
    }

    var paramData = {
        "userId": userId,
        "userName": userName,
        "password": password,
        "sex": sex,
        "age": age,
        "phone": phone,
        "mail": mail
    }

    $.ajax(
        {
            type: "post",
            dataType: "json",
            url: url,
            data: JSON.stringify(paramData),
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                result = data.data;
                // alert(data.errMsg);
                // ng(data);

            }
            ,
            error: function () {
                // ng(data);
            }

        });
}

// function ok(data) {
//     alert("登录成功");
// }
//
// function ng(data) {
//     if (data.resultCode == 0) {
//         alert(data.resultCode);
//     }
//     if (data.resultCode == 1) {
//         alert(data.resultCode);
//     }
//     alert("登录失败");
// }