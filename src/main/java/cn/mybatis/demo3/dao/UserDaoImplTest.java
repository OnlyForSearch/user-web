package cn.mybatis.demo3.dao;

import cn.mybatis.demo.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : fengyu
 * @since  2016-01-20
 */
public class UserDaoImplTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }


    @Test
    public void testDataSource() {
        Object dataSource = applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }
    @Test
    public void testSqlSessionFactory() {
        Object dataSource = applicationContext.getBean("sqlSessionFactory");
        System.out.println(dataSource);
    }
    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = userDao.findUserById(3);
        System.out.println(user);
    }
}