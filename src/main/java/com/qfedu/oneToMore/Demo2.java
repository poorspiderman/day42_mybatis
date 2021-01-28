package com.qfedu.oneToMore;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Demo2 {
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

    public static void findEmpByDid(){
        SqlSession sqlSession = factory.openSession();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department empByDid = mapper.findEmpByDid(2);
        List<Employee> employeeList = empByDid.getEmployeeList();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    public static void findEmpByDid2(){
        SqlSession sqlSession = factory.openSession();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department empByDid2 = mapper.findEmpByDid2(1);
        List<Employee> employeeList = empByDid2.getEmployeeList();
        for (Employee employee : employeeList) {
            System.out.println(employee.getEname());
        }
        sqlSession.commit();
        sqlSession.close();
    }

    public static void findEmpByDid3(){
        SqlSession sqlSession = factory.openSession();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department empByDid2 = mapper.findEmpByDid3(1);
        List<Employee> employeeList = empByDid2.getEmployeeList();
        for (Employee employee : employeeList) {
            System.out.println(employee.getEname());
        }
        sqlSession.commit();
        sqlSession.close();
    }

    public static void main(String[] args) {
        findEmpByDid3();
    }
}
