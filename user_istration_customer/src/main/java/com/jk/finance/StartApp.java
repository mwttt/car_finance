package com.jk.finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

@ImportResource("classpath:dubbo_customer.xml")//加载spring配置文件 相当于web.xml中spring的监听
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//加载spring环境 扫描(本包及子包)spring注解 读取app核心配置文件
//@EnableTransactionManagement//事务管理
@MapperScan("com.jk.finance.mapper") //扫描mapperceng
public class StartApp {

    public static void main(String[] args) throws Exception {
    	//springboot启动命令

        SpringApplication.run(StartApp.class, args);
    }
}
