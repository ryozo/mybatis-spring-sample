package net.equj65.spring.mybatis;

import net.equj65.spring.mybatis.entity.User;
import net.equj65.spring.mybatis.service.SimpleTableAccessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    SimpleTableAccessService simpleTableAccessService;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        App app = new App();
        app.simpleTableAccess(context.getBean(SimpleTableAccessService.class));
    }

    private void simpleTableAccess(SimpleTableAccessService service) {
        System.out.println("単一TableのCRUD ---------------------------");
        System.out.println("0. initial state");
        service.findAllUsers().forEach(this::indentOut);

        // insert
        System.out.println();
        System.out.println("1. Insert");
        User user = new User("U0004", "siro watanabe", 50);
        System.out.println("  [user instance before the insert]");
        indentOut(user);

        service.persistUser(user);

        System.out.println("  [user instance after the insert]");
        indentOut(user);


        // update
        System.out.println();
        System.out.println("2. Update");

        user.setMail("siro@example.com");
        service.persistUser(user);

        System.out.println("  [user instance after the update]");
        this.indentOut(user);

        // delete
        System.out.println();
        System.out.println("3. Delete");

        User removeUser = service.findUserById(1L);
        service.removeUser(removeUser);

        System.out.println("  [all users after the deletion run]");
        service.findAllUsers().forEach(this::indentOut);
    }

    private void indentOut(User user) {
        StringBuilder builder = new StringBuilder();
        builder.append("    ").append(user.toString());
        System.out.println(builder.toString());
    }

}
