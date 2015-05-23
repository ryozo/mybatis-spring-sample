package net.equj65.spring.mybatis.service;

import net.equj65.spring.mybatis.entity.User;
import net.equj65.spring.mybatis.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 単一テーブルへのアクセスを目的としたサービスクラスです。
 */
@Component
public class SimpleTableAccessService {

    @Autowired
    UserMapper userMapper;

    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    public User findUserById(Long id) {
        return userMapper.getUserById(id);
    }

    public User persistUser(User user) {
        if (user.getId() == null) {
            userMapper.insertUser(user);
        } else {
            userMapper.updateUser(user);
        }
        return user;
    }

    public void removeUser(User user) {
        if (user == null || user.getId() == null) {
            throw new IllegalArgumentException("user id is null");
        }
        userMapper.deleteUser(user.getId());
    }

}
