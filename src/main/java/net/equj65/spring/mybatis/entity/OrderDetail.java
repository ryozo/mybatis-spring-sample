package net.equj65.spring.mybatis.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail extends BaseEntity {
    private static final long serialVersionUID = -8112253442622800367L;
    private Integer count;
    private Order order;
    private Product product;
}
