package cn.mybatis.demo2.po;

import cn.mybatis.demo.po.User;

import java.sql.Date;
import java.util.List;

/**
 *
 * Created by Administrator on 2016/1/20 0020.
 */
public class Orders {
   private Integer id;
    private Integer userId;
    private String number;
    private Date createtime;
    private String node;

    private User user;
    private List<OrderDetail>orderDetails;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", node='" + node + '\'' +
                ", user=" + user +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
