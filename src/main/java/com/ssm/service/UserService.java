package com.ssm.service;

import com.ssm.getvo.UserVo;
import com.ssm.requestbo.RegisterRequestBo;
import com.ssm.requestbo.UserLoginRequestBo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface UserService {
    UserVo login(UserLoginRequestBo requestBo, HttpSession session, HttpServletResponse response);
    Boolean addUser(RegisterRequestBo requestBo, HttpSession session, HttpServletResponse response);
}
