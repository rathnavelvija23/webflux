package com.spring.reactive.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
public class WebFluxMonoTest {

    @Test
    public void testMono(){
       // Mono.just(1);
        Mono<?> stringMono = Mono.just("Vija")
                .then(Mono.error(new RuntimeException("Internal server Error")))
                .doOnError( ex -> {
                    System.out.println("Error occured"+ ex.getMessage());
                })
                .onErrorReturn("Fallback  value") //this will work above do on error wont work
                .log();
        stringMono.subscribe( e-> {
            System.out.println(e);
        });
    }

    @Test
    public void testFlux(){
        Flux<?> stringFlux =
                Flux.just("Spring","Reactive","Programming","Web")
                        .concatWithValues("Flux")
                        .concatWith(Flux.error(new RuntimeException("Internal Server Error")))
                        .concatWithValues("This won't be concated as after error this subscribe ")
                        .log();
        stringFlux.subscribe(e -> {
            System.out.println(e);
        }, ex -> {
                    System.out.println(ex.getMessage());
                }
        );

    }
}
