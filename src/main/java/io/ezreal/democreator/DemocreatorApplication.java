package io.ezreal.democreator;

import reactor.core.publisher.Flux;

public class DemocreatorApplication {

    public static void main(String[] args) {

        //A가 찍힘
        Flux<String> flux = Flux.just("A");
        flux.map(i -> "foo"+i);
        flux.subscribe(System.out::print);

        //fooA가 찍힘.
        Flux<String> flux_ = Flux.just("A");
        Flux<String> flux2_ = flux_.map(i -> "foo"+i);
        flux2_.subscribe(System.out::print);
    }
}
