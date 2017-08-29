package com.ssm.service.impl;

import com.ssm.dao.GeneralDao;
import com.ssm.dao.UserDao;
import com.ssm.getvo.UserVo;
import com.ssm.requestbo.RegisterRequestBo;
import com.ssm.requestbo.UserLoginRequestBo;
import com.ssm.service.UserService;
import com.ssm.sqlbo.RegisterInsertBo;
import com.ssm.sqlbo.UserLoginSelBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

//    @Resource
//    private UserDao userDao;

    @Autowired
    private GeneralDao dao;

    @Override
    public UserVo login(UserLoginRequestBo requestBo, HttpSession session, HttpServletResponse response) {

        UserLoginSelBo paramBo = new UserLoginSelBo();
        paramBo.setUserId(requestBo.getUserId());
        paramBo.setPassword(requestBo.getPassword());
        UserVo userVo = null;
//        userVo = userDao.sel_user01(paramBo);
        userVo = dao.getEntity(UserVo.class, "user.sel_user01", paramBo);
        session.setAttribute("username", userVo.getUserName());
        return userVo;
    }

    @Override
    public boolean addUser(RegisterRequestBo requestBo, HttpSession session, HttpServletResponse response) {
        RegisterInsertBo registerInsertBo = new RegisterInsertBo();
        String userNo = UUID.randomUUID().toString();
        registerInsertBo.setUserNo(userNo);
        registerInsertBo.setUserId(requestBo.getUserId());
        registerInsertBo.setUserName(requestBo.getUserName());
        registerInsertBo.setPassword(requestBo.getPassword());
        registerInsertBo.setSex(requestBo.getSex());
        registerInsertBo.setAge(requestBo.getAge());
        registerInsertBo.setPhone(requestBo.getPhone());
        registerInsertBo.setMail(requestBo.getMail());
        registerInsertBo.setUserType(0);
        registerInsertBo.setDelFlg(0);
        try {
//            userDao.insert_user01(registerInsertBo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
