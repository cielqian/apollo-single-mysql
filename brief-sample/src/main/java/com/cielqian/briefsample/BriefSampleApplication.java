package com.cielqian.briefsample;

import com.cielqian.briefconfig.auto.annotation.EnableBriefConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBriefConfig
@SpringBootApplication
public class BriefSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BriefSampleApplication.class, args);
    }

}
