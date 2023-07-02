package io.datajek.spring.baiscs.movierecommendersystem;

import io.datajek.spring.baiscs.movierecommendersystem.filters.ContentBasedFilter;
import io.datajek.spring.baiscs.movierecommendersystem.filters.Filter;

public class RecommenderImplementation {

    private final Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");
        return this.filter.getRecommendations(movie);
    }
}
