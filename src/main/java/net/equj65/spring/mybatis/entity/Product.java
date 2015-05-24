package net.equj65.spring.mybatis.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    private static final long serialVersionUID = 8730807312936451531L;
    private String productCode;
    private String name;
    private Integer price;
}
