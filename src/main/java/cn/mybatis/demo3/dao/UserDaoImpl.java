package cn.mybatis.demo3.dao;

import cn.mybatis.demo.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author: fengyu
 * @time: 2016-01-20
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = getSqlSession();
        User user = sqlSession.selectOne("cn.mybatis.demo.mapper.UserMapper.findUserById", id);
        return user;
    }
}
