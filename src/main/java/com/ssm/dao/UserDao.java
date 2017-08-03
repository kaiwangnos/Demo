package com.ssm.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import com.ssm.getvo.UserVo;

@Repository
public interface UserDao {
    List<UserVo> sel_user01();
}
