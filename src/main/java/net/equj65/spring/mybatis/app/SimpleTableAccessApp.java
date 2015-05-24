package net.equj65.spring.mybatis.app;

import net.equj65.spring.mybatis.entity.User;
import net.equj65.spring.mybatis.service.SimpleTableAccessService;
import net.equj65.spring.mybatis.util.EntityOutputUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static net.equj65.spring.mybatis.util.EntityOutputUtils.indentStdOut;

@Component
public class SimpleTableAccessApp {
    @Autowired
    SimpleTableAccessService service;

    public void start() {
        System.out.println("単一TableのCRUD ---------------------------");
        System.out.println("0. initial state");
        service.findAllUsers().forEach(EntityOutputUtils::indentStdOut);

        // insert
        System.out.println();
        System.out.println("1. Insert");
        User user = new User("U0004", "siro watanabe", 50);
        System.out.println("  [user instance before the insert]");
        indentStdOut(user);

        service.persistUser(user);

        System.out.println("  [user instance after the insert]");
        indentStdOut(user);


        // update
        System.out.println();
        System.out.println("2. Update");

        user.setMail("siro@example.com");
        service.persistUser(user);

        System.out.println("  [user instance after the update]");
        indentStdOut(user);

        // delete
        System.out.println();
        System.out.println("3. Delete");

        User removeUser = service.findUserById(4L);
        service.removeUser(removeUser);

        System.out.println("  [all users after the deletion run]");
        service.findAllUsers().forEach(EntityOutputUtils::indentStdOut);
    }

}
