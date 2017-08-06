package com.ssm.controller;

import com.ssm.getvo.UserVo;
import com.ssm.requestbo.UserLoginRequestBo;
import com.ssm.resultvo.Resultvo;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("login")
//    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Resultvo login(@RequestBody UserLoginRequestBo requestBo, HttpServletRequest request, HttpServletResponse response) {

        Resultvo result = new Resultvo();
        boolean ret = false;
        String errorMessage = "";
        List<UserVo> userVo = null;
        try {
            userVo = userService.login(requestBo, response);
            ret = true;
        } catch (Exception e) {
            errorMessage = "服务器异常！！请重新登录";
        }
        result.setResultCode(ret ? 0 : 1);
        result.setErrMsg(ret ? "" : errorMessage);
        result.setData(userVo);

        //返回数据
        return result;
    }
}
