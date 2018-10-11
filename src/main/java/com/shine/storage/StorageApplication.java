package com.shine.storage;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableSwagger2Doc
@SpringBootApplication
//mapper包扫描
@MapperScan("com.shine.storage.dao.mapper")
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }
}
