package cn.mybatis.demo.mapper;

import cn.mybatis.demo.po.User;
import cn.mybatis.demo.po.UserQueryVo;

import java.util.List;


public interface UserMapper {

    User findUserById(int id);


    //插入用户
     void insertUser(User user) throws Exception;
     void updateUser(User user) throws Exception;


    //删除用户
     void deleteUser(int id) throws Exception;


    List<User> findUserByName(String username)throws Exception;

    User findUserByIdResultMap(int id) throws Exception;

    int findUserCount(UserQueryVo userQueryVo)throws Exception;

    List<User> findUserList(UserQueryVo userQueryVo)throws Exception;

}
