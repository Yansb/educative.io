package io.datajek.spring.baiscs.movierecommendersystem;

import io.datajek.spring.baiscs.movierecommendersystem.filters.ContentBasedFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {
        final var appContext = SpringApplication.run(
                MovieRecommenderSystemApplication.class, args
        );

        final var cbf1 = appContext.getBean(ContentBasedFilter.class);
        final var cbf2 = appContext.getBean(ContentBasedFilter.class);
        final var cbf3 = appContext.getBean(ContentBasedFilter.class);

        System.out.println("cbf1: " + cbf1);
        System.out.println("cbf2: " + cbf2);
        System.out.println("cbf3: " + cbf3);
    }

}
