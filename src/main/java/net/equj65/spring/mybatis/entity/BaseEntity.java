package net.equj65.spring.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 各Entityの共通親クラスです.
 */
@Data
public abstract class BaseEntity implements Serializable {

    private Long id;

    // TODO optimistic lock
}
