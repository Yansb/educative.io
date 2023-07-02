package io.datajek.spring.baiscs.movierecommendersystem;

public class RecommenderImplementation {

    public String[] recommendMovies(String movie) {
        final var filter = new ContentBasedFilter();
        return filter.getRecommendations(movie);
    }
}
