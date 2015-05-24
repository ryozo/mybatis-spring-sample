package net.equj65.spring.mybatis.persistence;

import net.equj65.spring.mybatis.entity.Product;

public interface ProductMapper {

    Product getProductById(Long id);

}
