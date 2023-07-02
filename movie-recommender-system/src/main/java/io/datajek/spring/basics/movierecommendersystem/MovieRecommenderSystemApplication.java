package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {
        "io.datajek.spring.basics.otherPackage",
})
@ComponentScan(includeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
        pattern = "io.datajek.spring.basics.movierecommendersystem.*"
))
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {
        final var appContext = new AnnotationConfigApplicationContext(MovieRecommenderSystemApplication.class);

        final var recommender = appContext.getBean(RecommenderImplementation.class);
        System.out.println(recommender);
        System.out.println(recommender.getFilter());

        appContext.close();
    }

}
