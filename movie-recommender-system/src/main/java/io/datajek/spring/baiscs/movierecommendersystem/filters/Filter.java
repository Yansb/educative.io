package io.datajek.spring.baiscs.movierecommendersystem.filters;

public interface Filter {
    public String[] getRecommendations(String movie);
}
