package net.equj65.spring.mybatis.entity;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity {
    private static final long serialVersionUID = 2268515655320126913L;
    @NonNull
    private String orderCode;
    // TODO TypeHanlderを利用してJava8のLocalDateTimeを利用可能にする
    @NonNull
    private Timestamp orderDate;
    @NonNull
    private User user;
    private List<OrderDetail> orderDetails;
}
