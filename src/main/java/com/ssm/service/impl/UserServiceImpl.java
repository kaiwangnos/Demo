package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.getvo.UserVo;
import com.ssm.requestbo.UserLoginRequestBo;
import com.ssm.service.UserService;
import com.ssm.sqlbo.UserLoginSelBo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<UserVo> login(UserLoginRequestBo requestBo, HttpServletResponse response) {

        UserLoginSelBo paramBo = new UserLoginSelBo();
        paramBo.setUserName(requestBo.getUserName());
        paramBo.setPassWord(requestBo.getPassWord());
        List<UserVo> userVo = null;
        userVo = userDao.sel_user01(paramBo);
        return userVo;
    }
}
