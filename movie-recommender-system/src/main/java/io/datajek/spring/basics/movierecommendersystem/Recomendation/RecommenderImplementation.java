package io.datajek.spring.basics.movierecommendersystem.Recomendation;

import io.datajek.spring.basics.movierecommendersystem.filters.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service()
public class RecommenderImplementation {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Filter filter;


    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");
        return this.filter.getRecommendations(movie);
    }

    @Autowired
    public void setFilter(Filter filter) {
        logger.info("In RecommenderImplementation setter method..depedency injection");
        this.filter = filter;
    }
}
