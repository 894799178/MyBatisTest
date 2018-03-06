package com.mybatist.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //获取配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream("User-config.xml");
        //初始化MyBatis 创建sqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取会话
        SqlSession session = sqlSessionFactory.openSession();
        User user  = new User("admin","男",15);
        session.insert("com.mybatist.domain.User-Mapping.save",user);
        //提交事务
        session.commit();
        session.close();
    }
}
