package io.datajek.spring.basics.otherPackage;

import io.datajek.spring.basics.movierecommendersystem.filters.Filter;
import org.springframework.stereotype.Component;

@Component("OF")
public class OtherFilter implements Filter {
    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Other Movie 1", "Other Movie 2", "Other Movie 3"};
    }
}
