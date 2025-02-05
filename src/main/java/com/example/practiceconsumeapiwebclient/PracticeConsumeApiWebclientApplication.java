package com.example.practiceconsumeapiwebclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PracticeConsumeApiWebclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeConsumeApiWebclientApplication.class, args);
    }

}
