package net.equj65.spring.mybatis;

import net.equj65.spring.mybatis.app.ComplexTableAccessApp;
import net.equj65.spring.mybatis.app.SimpleTableAccessApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean(SimpleTableAccessApp.class).start();
        context.getBean(ComplexTableAccessApp.class).start();
    }
}
