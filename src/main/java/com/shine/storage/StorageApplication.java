package com.shine.storage;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableSwagger2Doc
@SpringBootApplication
//mapper包扫描
@MapperScan("com.shine.storage.dao.mapper")
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StorageApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        // application.setAdditionalProfiles("prod");
        application.run(args);
    }
}
