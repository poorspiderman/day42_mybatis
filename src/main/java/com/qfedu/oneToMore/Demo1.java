package com.qfedu.oneToMore;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Demo1 {
    private static SqlSessionFactory factory = null;
    static {
        Reader resourceAsReader = null;
        try {
            resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void selectAllById(){
        SqlSession sqlSession = factory.openSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        mapper.selectAllById(1);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void select1(){
        SqlSession sqlSession = factory.openSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = mapper.select1(2);
        System.out.println(employee.getDept());
        sqlSession.commit();
        sqlSession.close();
    }

    public static void selectById(){
        SqlSession sqlSession = factory.openSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = mapper.selectByEid(2);
        System.out.println(employee.getDept().getDname());
        sqlSession.commit();
        sqlSession.close();
    }

    public static void main(String[] args) {
        //select1();
        selectById();
    }
}
