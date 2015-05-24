package net.equj65.spring.mybatis.entity;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    private static final long serialVersionUID = -2175047969821475232L;
    @NonNull
    private String userId;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    private String mail;
}
