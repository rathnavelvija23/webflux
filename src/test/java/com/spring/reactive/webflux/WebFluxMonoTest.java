package com.spring.reactive.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

@SpringBootTest
public class WebFluxMonoTest {

    @Test
    public void Mono(){
       // Mono.just(1);
        Mono<String> stringMono = Mono.just("2").log();
        stringMono.subscribe();
    }
}
