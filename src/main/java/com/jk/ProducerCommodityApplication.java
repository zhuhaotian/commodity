package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//声明此项目是一个生产者
@MapperScan("com.jk.mapper")
public class ProducerCommodityApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProducerCommodityApplication.class, args);
    }

}

