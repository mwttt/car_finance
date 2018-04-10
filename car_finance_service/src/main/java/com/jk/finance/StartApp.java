package com.jk.finance;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@ImportResource(locations={"classpath:dubbo_provider.xml", "classpath:spring-common.xml"})
@ImportResource("classpath:dubbo_provider.xml")
@EnableTransactionManagement//事务管理
@SpringBootApplication
@MapperScan("com.jk.finance.mapper")//扫描mapperceng
public class StartApp {

    public static void main(String[] args) {

        SpringApplication.run(StartApp.class, args);

    }

}
