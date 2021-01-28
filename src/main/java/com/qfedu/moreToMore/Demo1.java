package com.qfedu.moreToMore;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

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

    public static void findCourseBySid(){
        SqlSession sqlSession = factory.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student courceBySid = mapper.findCourseBySid(2);
        List<Course> courseList = courceBySid.getCourseList();
        for (Course course : courseList) {
            System.out.println(course.getCname());
        }
        sqlSession.commit();
        sqlSession.close();
    }

    public static void main(String[] args) {
        findCourseBySid();
    }
}
