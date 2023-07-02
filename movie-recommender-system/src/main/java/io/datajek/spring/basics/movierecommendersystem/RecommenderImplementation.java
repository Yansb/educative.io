package io.datajek.spring.basics.movierecommendersystem;

import io.datajek.spring.basics.movierecommendersystem.filters.Filter;

import javax.inject.Named;


@Named
public class RecommenderImplementation {

    private final Filter filter;

    public RecommenderImplementation(Filter filter) {
        this.filter = filter;
    }


    public String[] recommendMovies(String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");
        return this.filter.getRecommendations(movie);
    }

//    @Autowired
//    public void setFilter(Filter filter) {
//        logger.info("In RecommenderImplementation setter method..depedency injection");
//        this.filter = filter;
//    }

    public Filter getFilter() {
        return filter;
    }

}
