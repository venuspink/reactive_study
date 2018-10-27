package io.ezreal.democreator;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class DemocreatorApplication {

    public static void main(String[] args) throws InterruptedException{

        //A가 찍힘
        Flux<String> flux = Flux.just("A");
        flux.map(i -> "foo"+i);
        flux.subscribe(System.out::println);

        //fooA가 찍힘.
        Flux<String> flux_ = Flux.just("A");
        Flux<String> flux2_ = flux_.map(i -> "foo"+i);
        flux2_.subscribe(System.out::println);

        //무한의 퍼블리셔. 10개만 구독
        Flux.interval(Duration.ofMillis(100))
                .take(10)
                .subscribe(System.out::println);

        System.out.println("찍기...");

        Thread.sleep(5000);

    }
}
