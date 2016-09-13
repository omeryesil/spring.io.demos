package com.awapi.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by yesiome on 9/7/2016.
 */

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main (String[] args)  throws Exception
    {
        SpringApplication.run(Application.class);
    }
}
