package net.equj65.spring.mybatis.persistence;

import net.equj65.spring.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> findAllUsers();

    User getUserById(Long id);

    long insertUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
