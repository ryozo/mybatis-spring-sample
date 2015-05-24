package net.equj65.spring.mybatis.service;

import net.equj65.spring.mybatis.entity.Order;
import net.equj65.spring.mybatis.entity.OrderDetail;
import net.equj65.spring.mybatis.persistence.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 複数Tableへのアクセスを目的としたサービスクラスです.
 * 今回はmybatis-springのサンプルのため、serviceをテーブルへのアクセスの粒度で切り分けています.
 * これは本来のServiceレイヤの切り分け方とは異なる点にご注意ください.
 */
@Component
public class ComplexTableAccessService {

    @Autowired
    OrderMapper orderMapper;

    /**
     * 全ての{@link Order}(注文)を取得します.
     * 返却される{@code Order}インスタンスは以下の情報を内包しています.
     * <pre>
     *     {@code OrderDetails} - 指定された注文の注文明細
     *     {@code Product} - 商品（個々の注文明細に紐付く商品）
     *     {@code User} - 指定された注文の注文者
     * </pre>
     * @return Orderの一覧
     */
    public List<Order> findAllOrders() {
        return orderMapper.findAllOrderWithProductAndDetails();
    }

    /**
     * 新規注文を作成します。
     * 引数に指定された{@link Order}および内包する{@link net.equj65.spring.mybatis.entity.OrderDetail}を新規作成します。
     * @param order 新規作成対象の{@code Order}
     * @return 作成後のOrder
     */
    @Transactional
    public Order makeOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order is null");
        }
        if (order.getOrderDetails() == null
                || order.getOrderDetails().isEmpty()) {
            throw new IllegalArgumentException("order details is empty");
        }

        // insert
        orderMapper.insertOrder(order);
        order.getOrderDetails().forEach(orderMapper::insertOrderDetail);

        return order;
    }

}
