package com.ssm.controller;

import com.ssm.getvo.UserVo;
import com.ssm.resultvo.Resultvo;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("login")
    @ResponseBody
    public Resultvo login() {
        Resultvo resultvos = new Resultvo();
        try {
            List<UserVo> userVo = null;
            userVo = userService.login();
            resultvos.setData(userVo);

        } catch (Exception e) {
            resultvos.setErrMsg("服务器异常！！请重新登录");
            resultvos.setResultCode(1);
        }

        //返回数据
        return resultvos;
    }
}
