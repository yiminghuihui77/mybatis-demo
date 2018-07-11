package com.minghui.jdbc.mapper;

import com.minghui.jdbc.annotation.MySelect;
import com.minghui.jdbc.domain.User;

/**
 * 用户接口
 *
 * @author minghui.y
 * @create 2018-07-11 21:52
 **/
public interface UserMapper {

    @MySelect("SELECT * FROM crm_user")
    User selectUser();
}
