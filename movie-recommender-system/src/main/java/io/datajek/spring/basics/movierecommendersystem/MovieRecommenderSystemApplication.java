package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {
        "io.datajek.spring.basics.otherPackage",
})
@ComponentScan(includeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
        pattern = "io.datajek.spring.basics.movierecommendersystem.*"
))
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {
        final var appContext = SpringApplication.run(
                MovieRecommenderSystemApplication.class, args
        );

        System.out.println("OtherFilter bean found = " +
                appContext.containsBean("OF"));
        System.out.println("CollaborativeFilter bean found = " +
                appContext.containsBean("CF"));
    }

}
