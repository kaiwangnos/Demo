$(document).ready(function () {
    //点击登录按钮
    $("#login").click(function () {
        login();
    });


});


function login() {
    var url = "http://localhost:8080/demo/login";
    var userName = document.getElementById("username").value;
    var passWord = document.getElementById("password").value;

    var paramData = {
        "userName": userName,
        "passWord": passWord
    }

    // $.post(url, JSON.stringify(parmData), function (data) {
    //     if (data.resultCode = true) {
    //         alert("ajax成功");
    //     } else {
    //         alert("ajax异常");
    //     }
    // }, "json");


    // $.post(url, paramData, function (data) {
    //     ok(data);
    // });

    $.ajax(
        {
            type: "post",
            dataType:"json",
            url: url,
            data: JSON.stringify(paramData),
            contentType: "application/json;charset=utf-8",
            success: function (data) {

                    // alert(data.errMsg);
                     ng(data);

            }
            ,
            error: function () {
                ng(data);
            }

        }
    );
}

function ok(data) {
    alert("登录成功");
}

function ng(data) {
    if(data.resultCode==0){
        alert(data.resultCode);
    }
    if(data.resultCode==1){
        alert(data.resultCode);
    }
    alert("登录失败");
}