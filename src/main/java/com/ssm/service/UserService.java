package com.ssm.service;

import com.ssm.getvo.UserVo;
import com.ssm.requestbo.UserLoginRequestBo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
     List<UserVo> login(UserLoginRequestBo requestBo, HttpServletResponse response);
}
