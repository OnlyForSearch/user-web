package cn.mybatis.demo.mapper;

import cn.mybatis.demo.po.User;
import cn.mybatis.demo.po.UserCustom;
import cn.mybatis.demo.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserMapperTest {
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
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setBirthday(new Date());
        user.setUsername("test");
        user.setSex("2");
        user.setAddress("地址");

         userMapper.insertUser(user);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        userMapper.deleteUser(29);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindUserByName() throws Exception {


        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<User> userList = userMapper.findUserByName("三");
            System.out.println(userList);


    }

    @Test
    public void testFindUserByIdResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserByIdResultMap(1);
        System.out.println("user = " + user);


    }

    @Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserCustom userCustom=new UserCustom();
        userCustom.setUsername("张三丰");
        userCustom.setSex("1");
        UserQueryVo queryVo = new UserQueryVo();
        queryVo.setUserCustom(userCustom);
        int userCount = mapper.findUserCount(queryVo);
        System.out.println("userCount = " + userCount);

    }

    @Test
    public void testFindUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("1");
        userQueryVo.setUserCustom(userCustom);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        userQueryVo.setIds(ids);

        List<User> userList = userMapper.findUserList(userQueryVo);
        System.out.println("userList = " + userList);

    }

}