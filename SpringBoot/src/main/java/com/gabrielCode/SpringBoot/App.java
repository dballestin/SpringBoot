package com.gabrielCode.SpringBoot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gabrielCode.beans.Mundo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/gabrielCode/xml/beans.xml");
        Mundo m = (Mundo)appContext.getBean("mundo");
        System.out.println(m.getSaludo());
        ((ConfigurableApplicationContext)appContext).close();
    }
}
