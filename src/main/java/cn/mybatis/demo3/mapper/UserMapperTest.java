package cn.mybatis.demo3.mapper;

import cn.mybatis.demo.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fengyu
 * @since 2016-01-20
 */
public class UserMapperTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }
    @Test
    public void testFindUserById() throws Exception {
        UserMapper  userMapper= (UserMapper) applicationContext.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);

    }
}