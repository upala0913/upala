package com.upala.wong;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Log4j2
@ComponentScan(basePackages = {"com.upala.wong.mapper"})
public class DocumentApp
{

    public static void main( String[] args )
    {
        log.info("SpringBoot start......");
        SpringApplication.run(DocumentApp.class, args);
        log.info("SpringBoot started......");
    }

}
