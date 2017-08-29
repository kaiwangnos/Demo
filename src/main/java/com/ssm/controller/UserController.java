package com.ssm.controller;

import com.ssm.getvo.UserVo;
import com.ssm.requestbo.RegisterRequestBo;
import com.ssm.requestbo.UserLoginRequestBo;
import com.ssm.resultvo.Resultvo;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/registerPage")
    public String registerPage() {
        return "register";
    }

    @ResponseBody
    @PostMapping("/login")
    public Resultvo login(@RequestBody UserLoginRequestBo requestBo, HttpServletRequest request,
                          HttpSession session, HttpServletResponse response) {
        Resultvo result = new Resultvo();
        List<UserVo> dataList = new ArrayList<>();
        boolean ret = false;
        String errorMessage = "";
        UserVo userVo = null;
        try {
            userVo = userService.login(requestBo, session, response);
            if (userVo != null) {
                ret = true;
                dataList.add(userVo);
            } else {
                errorMessage = "用户名或密码错误！";
                ret = false;
            }
        } catch (Exception e) {
            errorMessage = "服务器异常！！请重新登录";
            ret = false;
        }
        result.setResultCode(ret ? 0 : 1);
        result.setErrMsg(ret ? "" : errorMessage);
        result.setData(dataList);

        //返回数据
        return result;
    }

    @PostMapping("/register")
    public Resultvo addUser(@RequestBody RegisterRequestBo requestBo, HttpServletRequest request,
                            HttpSession session, HttpServletResponse response) {
        Resultvo result = new Resultvo();
        boolean ret = false;
        String errorMessage = "";

        try {
            ret = userService.addUser(requestBo, session, response);
            if (!ret) {
                errorMessage = "服务器异常，注册失败！";
            }
        } catch (Exception e) {
            errorMessage = "服务器异常，注册失败！";
        }
        result.setResultCode(ret ? 0 : 1);
        result.setErrMsg(ret ? "" : errorMessage);
        //返回数据
        return result;
    }

}
