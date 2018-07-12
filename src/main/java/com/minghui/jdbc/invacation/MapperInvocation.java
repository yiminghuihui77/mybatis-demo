package com.minghui.jdbc.invacation;

import com.minghui.jdbc.annotation.MySelect;
import com.minghui.jdbc.domain.User;
import com.minghui.jdbc.executor.JDBCExecutor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * JDK动态代理所需
 *
 * @author minghui.y
 * @create 2018-07-11 21:18
 **/
public class MapperInvocation implements InvocationHandler {

    /**
     * 根据method中的信息，获取注解信息、方法名称，然后执行不同的任务
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行任务....");
        MySelect annotation = method.getAnnotation(MySelect.class);
        String sql = annotation.value();
        List<User> userList = JDBCExecutor.doSelect(sql);
        return userList;
    }
}
