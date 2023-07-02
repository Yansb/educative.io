package io.datajek.spring.basics.movierecommendersystem.filters;

import io.datajek.spring.basics.movierecommendersystem.movie.Movie;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("CBF")
@Primary
public class ContentBasedFilter implements Filter {
    private static int instances = 0;
    private final Movie movie;

    public ContentBasedFilter(Movie movie) {
        this.movie = Objects.requireNonNull(movie);
        instances++;
        System.out.println("ContentBasedFilter instance no. " + instances + " created");
    }

    public static int getInstances() {
        return ContentBasedFilter.instances;
    }

    public String[] getRecommendations(String movie) {
        // logic of content based filter
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }

    public Movie getMovie() {
        return movie;
    }
}
