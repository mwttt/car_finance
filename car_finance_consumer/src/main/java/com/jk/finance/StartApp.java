package com.jk.finance;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ImportResource;


//@ImportResource(locations={"classpath:dubbo_customer.xml", "classpath:spring-common.xml"})
@ImportResource("classpath:dubbo_customer.xml")
@SpringBootApplication
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class StartApp {

    public static void main(String[] args) {

        SpringApplication.run(StartApp.class, args);

    }

}
