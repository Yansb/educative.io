package io.datajek.spring.baiscs.movierecommendersystem.filters;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("CBF")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
public class ContentBasedFilter implements Filter {

    public String[] getRecommendations(String movie) {
        // logic of content based filter
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
