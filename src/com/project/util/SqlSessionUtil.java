package com.project.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtil {
    private static String resours="com/project/config/mybatis.xml";
    private static SqlSessionFactory sqlSessionFactory=null;
    private static SqlSession sqlSession=null;
    public SqlSessionUtil(){}
    public static SqlSession getSession(){
        try {
            InputStream inputStream = Resources.getResourceAsStream(resours);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession=sqlSessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
