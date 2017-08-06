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
    var parmData = {
        "userName": userName,
        "passWord": passWord
    }

    $.post(url, parmData, function (data) {
        if (data.resultCode = true) {
            alert("ajax成功");
        } else {
            alert("ajax异常");
        }
    }, "json");


    // $.ajax(
    //     {
    //         type: "post",
    //         url: url,
    //         data: parmData,
    //         dataType: "json",
    //         success: function (data, textStatus, jqXHR) {
    //             alert("ajax成功");
    //         },
    //         error: function () {
    //             alert("ajax异常");
    //         }
    //
    //     }
    // );
}

function ok(data, textStatus, jqXHR) {
    alert("ajax成功");
}