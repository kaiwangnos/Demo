package com.ssm.dao;

import com.ssm.sqlbo.UserLoginSelBo;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.ssm.getvo.UserVo;

@Repository
public interface UserDao {
    List<UserVo> sel_user01(UserLoginSelBo paramBo);
}
