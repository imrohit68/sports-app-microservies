package com.sportsapppoc.message.message.Functions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunction {
    private static final Logger log = LoggerFactory.getLogger(MessageFunction.class);
    @Bean
    public Function<String,String> sms(){
        return mobileNumber -> {
            log.info(mobileNumber);
            return mobileNumber;
        };
    }
}
