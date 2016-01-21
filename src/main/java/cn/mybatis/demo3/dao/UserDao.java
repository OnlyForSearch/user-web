package cn.mybatis.demo3.dao;

import cn.mybatis.demo.po.User;

/**
 * @author: fengyu
 * @time: 2016-01-20
 */
public interface UserDao {
    User findUserById(int id)throws  Exception;
}
