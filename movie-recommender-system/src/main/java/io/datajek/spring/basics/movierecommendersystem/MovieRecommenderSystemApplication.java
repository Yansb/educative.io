package io.datajek.spring.basics.movierecommendersystem;

import io.datajek.spring.basics.movierecommendersystem.Recomendation.RecommenderImplementation;
import io.datajek.spring.basics.movierecommendersystem.repositories.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {
        "io.datajek.spring.basics.otherPackage",
})
@ComponentScan(includeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
        pattern = "io.datajek.spring.basics.movierecommendersystem.*"
))
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {
        final var appContext = SpringApplication.run(
                MovieRecommenderSystemApplication.class, args
        );

        final var recommender = appContext.getBean(RecommenderImplementation.class);
        System.out.println(recommender);

        final var m1 = appContext.getBean(Movie.class);
        System.out.println(m1);
        final var m2 = appContext.getBean(Movie.class);
        System.out.println(m2);
    }

}
