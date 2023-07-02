package io.datajek.spring.basics.movierecommendersystem;

import io.datajek.spring.basics.movierecommendersystem.filters.ContentBasedFilter;
import io.datajek.spring.basics.movierecommendersystem.movie.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {
        final var appContext = SpringApplication.run(
                MovieRecommenderSystemApplication.class, args
        );

        final var filter = appContext.getBean(ContentBasedFilter.class);
        System.out.println("\n ContentBasedFilter bean with singleton scope");
        System.out.println(filter);

        final var movie1 = filter.getMovie();
        final var movie2 = filter.getMovie();
        final var movie3 = filter.getMovie();

        System.out.println("\n Movie bean with prototype scope");
        System.out.println("movie1: " + movie1);
        System.out.println("movie2: " + movie2);
        System.out.println("movie3: " + movie3);

        System.out.println("\n ContentBasedFilter instances: " + ContentBasedFilter.getInstances());
        System.out.println("Movie instances: " + Movie.getInstances());
    }

}
