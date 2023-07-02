package io.datajek.spring.baiscs.movierecommendersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {
        final var appContext = SpringApplication.run(
                MovieRecommenderSystemApplication.class, args
        );

        System.out.println("Calling getBean() on RecommenderImplementation");
        final var recommender = appContext.getBean(RecommenderImplementation.class);

        final var result = recommender.recommendMovies("Finding Dory");

        System.out.println(Arrays.toString(result));

        System.out.println("Calling getBean() on RecommenderImplementation2");
        final var recommender2 = appContext.getBean(RecommenderImplementation2.class);
        final var result2 = recommender2.recommendMovies("Finding Dory");
        System.out.println(Arrays.toString(result2));
    }

}
