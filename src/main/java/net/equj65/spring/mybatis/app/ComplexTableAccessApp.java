package net.equj65.spring.mybatis.app;

import ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
import net.equj65.spring.mybatis.entity.Order;
import net.equj65.spring.mybatis.entity.OrderDetail;
import net.equj65.spring.mybatis.entity.Product;
import net.equj65.spring.mybatis.entity.User;
import net.equj65.spring.mybatis.service.ComplexTableAccessService;
import net.equj65.spring.mybatis.service.SimpleTableAccessService;
import net.equj65.spring.mybatis.util.EntityOutputUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Component
public class ComplexTableAccessApp {
    @Autowired
    SimpleTableAccessService simpleService;

    @Autowired
    ComplexTableAccessService complexService;

    public void start() {
        System.out.println("複数TableのCRUD ---------------------------");
        System.out.println("0. initial state");
        // 複数テーブルのJoin、およびクエリのネスト
        complexService.findAllOrders().forEach(EntityOutputUtils::indentStdOut);

        System.out.println("1. 注文情報のInsert(原子性/一貫性が必要な登録処理)");
        Order newOrder = createNewOrder();
        complexService.makeOrder(newOrder);

        System.out.println("2. 新規注文の実施後の全Order");
        complexService.findAllOrders().forEach(EntityOutputUtils::indentStdOut);
    }

    private Order createNewOrder() {
        User orderedUser = simpleService.findUserById(3L);
        Instant instant = LocalDateTime.now().toInstant(ZoneOffset.ofHours(9));
        Order order = new Order("ORDER00004", Timestamp.from(instant), orderedUser);

        Product productA = simpleService.findProductById(1L);
        Product productB = simpleService.findProductById(2L);
        Product productE = simpleService.findProductById(5L);

        List<OrderDetail> detailList = new ArrayList<>();
        detailList.add(new OrderDetail(2, order, productA));
        detailList.add(new OrderDetail(1, order, productB));
        detailList.add(new OrderDetail(3, order, productE));
        order.setOrderDetails(detailList);

        return order;
    }
}
