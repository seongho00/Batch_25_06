package com.koreait.exam.batch_06_25;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Batch0625Application {

    public static void main(String[] args) {
        SpringApplication.run(Batch0625Application.class, args);
    }

}
