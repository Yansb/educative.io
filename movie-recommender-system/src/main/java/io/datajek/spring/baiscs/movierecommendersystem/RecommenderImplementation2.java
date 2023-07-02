package io.datajek.spring.baiscs.movierecommendersystem;

import io.datajek.spring.baiscs.movierecommendersystem.filters.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component()
public class RecommenderImplementation2 {

    private Filter filter;

    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");
        return this.filter.getRecommendations(movie);
    }

    @Autowired
    @Qualifier("CBF")
    public void setFilter(Filter filter) {
        this.filter = filter;
        System.out.println("Setter method invoked!");
    }
}
