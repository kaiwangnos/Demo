package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.getvo.UserVo;
import com.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public List<UserVo> login() {
//        List<UserVo> userVos = new ArrayList<>();
//        UserVo userVo1 = new UserVo();
//        userVo1.setAge(23);
//        userVo1.setBirthDay("1994-03-05");
//        userVo1.setNickName("二狗");
//        userVo1.setEmail("3985@mei.com");
//        userVos.add(userVo1);
//        return userVos;

        return userDao.sel_user01();
    }
}
