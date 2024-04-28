package com.qburry;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Hello world!
 */
@SpringBootApplication
public class DBMySQLApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DBMySQLApp.class).run(args);
    }
}
