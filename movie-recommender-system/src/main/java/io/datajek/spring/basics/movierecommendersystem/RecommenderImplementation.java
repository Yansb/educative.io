package io.datajek.spring.basics.movierecommendersystem;

import io.datajek.spring.basics.movierecommendersystem.filters.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component()
public class RecommenderImplementation {

    private final Filter filter;

    @Autowired
    public RecommenderImplementation(@Qualifier("CF") Filter filter) {
        this.filter = filter;
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");
        return this.filter.getRecommendations(movie);
    }
}
