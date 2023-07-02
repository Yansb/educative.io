package io.datajek.spring.basics.movierecommendersystem.filters;

import javax.inject.Named;

@Named
public class CollaborativeFilter implements Filter {

    public String[] getRecommendations(String movie) {
        // logic of collaborative filter
        return new String[]{"Avatar", "Titanic", "Star Wars"};
    }
}
