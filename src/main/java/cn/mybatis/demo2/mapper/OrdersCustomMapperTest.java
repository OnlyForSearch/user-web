package cn.mybatis.demo2.mapper;

import cn.mybatis.demo.mapper.UserMapper;
import cn.mybatis.demo.po.User;
import cn.mybatis.demo2.po.Orders;
import cn.mybatis.demo2.po.OrdersCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class OrdersCustomMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "mybatis/SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

    }
    @Test
    public void testFindOrdersUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<OrdersCustom> ordersUser = ordersCustomMapper.findOrdersUser();
        System.out.println("ordersUser = " + ordersUser);
        sqlSession.close();
    }

    @Test
    public void testFindOrdersAndOrderDetailResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<Orders> ordersAndOrderDetailResultMap = ordersCustomMapper.findOrdersAndOrderDetailResultMap();
        System.out.println(ordersAndOrderDetailResultMap);
        sqlSession.close();

    }

    @Test
    public void testFindUserAndItemsResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<User> userList = ordersCustomMapper.findUserAndItemsResultMap();

        System.out.println(userList);
        sqlSession.close();

    }

    @Test//测试二级缓存
    public void testCache2() throws Exception {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = userMapper1.findUserById(1);
        System.out.println("user1 = " + user1);
        sqlSession1.close();

/*
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        User user3 = userMapper3.findUserById(1);
        user3.setUsername("张明明");
        userMapper3.updateUser(user3);
        System.out.println("user3 = " + user1);
        sqlSession3.commit();
        sqlSession3.close();*/


        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2= userMapper2.findUserById(1);
        System.out.println("user2 = " + user2);
        sqlSession2.close();

    }


    @Test//延迟加载
    public void testFindOrdersUserLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<Orders> userList = ordersCustomMapper.findOrdersUserLazyLoading();
        for (Orders orders : userList) {
            User user = orders.getUser();
            System.out.println(user);
        }

        System.out.println(userList);
        sqlSession.close();
    }

    @Test//测试一级缓存
    public void testCache1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.findUserById(1);
        System.out.println("user1 = " + user1);
        user1.setUsername("测试用户222");
    userMapper.updateUser(user1);

       sqlSession.commit();
        User user2 = userMapper.findUserById(1);
        System.out.println("user2 = " + user2);
    sqlSession.close();
    }
}