package com.minghui.jdbc.test;

import com.minghui.jdbc.domain.User;
import com.minghui.jdbc.mapper.UserMapper;
import com.minghui.jdbc.session.MySqlSession;
import org.junit.Test;

/**
 * @author minghui.y
 * @create 2018-07-11 22:42
 **/
public class SessionDemo {

    @Test
    public void testDmeo() {
        UserMapper userMapper = new MySqlSession().getMapper(UserMapper.class);
        User user = userMapper.selectUser();
        System.out.println(user);
    }

}
