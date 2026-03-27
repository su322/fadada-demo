package com.yulintu.fadada.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.dtflys.forest.springboot.annotation.ForestScan;

@SpringBootApplication
@ForestScan(basePackages = "com.yulintu.fadada.demo")
public class FadadaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FadadaDemoApplication.class, args);
    }
}
