package cn.mybatis.demo2.mapper;

import cn.mybatis.demo.po.User;
import cn.mybatis.demo2.po.Orders;
import cn.mybatis.demo2.po.OrdersCustom;

import java.util.List;

/**
 * Created by Administrator on 2016/1/20 0020.
 */
public interface OrdersCustomMapper {
    List<OrdersCustom> findOrdersUser()throws Exception;

    List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;

    List<User>findUserAndItemsResultMap()throws Exception;

    List<Orders> findOrdersUserLazyLoading()throws Exception;

}
