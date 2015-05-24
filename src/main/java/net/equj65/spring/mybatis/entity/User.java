package net.equj65.spring.mybatis.entity;

import lombok.*;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1451499324494499891L;
    private Long id;
    @NonNull
    private String userId;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    private String mail;
}
