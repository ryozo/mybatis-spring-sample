package net.equj65.spring.mybatis.persistence;

import net.equj65.spring.mybatis.entity.Order;
import net.equj65.spring.mybatis.entity.OrderDetail;

import java.util.List;

public interface OrderMapper {

    List<Order> findAllOrderWithProductAndDetails();

    void insertOrder(Order order);

    void insertOrderDetail(OrderDetail orderDetail);

}
