package com.aiotx;

import com.aiotx.config.ApplicationConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {

    public static void main(String[] args) {
        // dont need to use this since we created a bean for it in resources.spring.xml
//        EmailService emailService = new EmailService();

        // this method is deprecated and you can create the Bean Factory with it.
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));

        // this is the current supported method of creating the Bean factory
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");

        // the better way to create beans using the application context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        EmailService emailService = applicationContext.getBean("emailService", EmailService.class);

        System.out.println(emailService);
        emailService.sendMessage("Joao", "Fala ai joao tudo bem");

        // now ge the email service from bean defined in a config.java file
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        EmailService emailService1 = applicationContext1.getBean("emailService", EmailService.class);
        System.out.println(emailService1);

        emailService1.sendMessage("EmailService1", " this was sent from emailservice from appconfig.java ");
    }
}
