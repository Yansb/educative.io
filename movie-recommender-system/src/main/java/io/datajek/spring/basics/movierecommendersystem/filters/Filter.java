package io.datajek.spring.basics.movierecommendersystem.filters;

public interface Filter {
    String[] getRecommendations(String movie);
}
