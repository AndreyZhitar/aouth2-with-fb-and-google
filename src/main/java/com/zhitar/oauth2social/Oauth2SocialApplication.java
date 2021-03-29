package com.zhitar.oauth2social;

import com.zhitar.oauth2social.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Oauth2SocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2SocialApplication.class, args);
    }

}
