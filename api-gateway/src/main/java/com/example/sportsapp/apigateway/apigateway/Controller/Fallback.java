package com.example.sportsapp.apigateway.apigateway.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Fallback {
    @RequestMapping("/profile/fallback")
    public Mono<String> profileFallback(){
        return Mono.just("The profile service is not responding please try after some time");
    }
    @RequestMapping("/event/fallback")
    public Mono<String> eventFallback(){
        return Mono.just("The event service is not responding please try after some time");
    }
}
