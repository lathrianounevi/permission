package com.company.permission.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.company.**.dao")
@ComponentScan(basePackages = "com.company")
//@EnableWebSecurity
public class PermissionAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PermissionAdminApplication.class, args);
    }

}
