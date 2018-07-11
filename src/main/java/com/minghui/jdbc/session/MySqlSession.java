package com.minghui.jdbc.session;

import com.minghui.jdbc.invacation.MapperInvocation;

import java.lang.reflect.Proxy;

/**
 * 模拟mybatis的SqlSession
 *
 * @author minghui.y
 * @create 2018-07-11 21:21
 **/
public class MySqlSession {

    private MapperInvocation invocation = new MapperInvocation();

    /**
     * 获取mapper的代理对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz}, invocation);
    }

}
