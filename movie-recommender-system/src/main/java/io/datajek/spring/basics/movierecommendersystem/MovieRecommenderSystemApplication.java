package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MovieRecommenderSystemApplication {
    public static void main(String[] args) {
        final var appContext = new ClassPathXmlApplicationContext("appContext.xml");
        System.out.println("\n Beans loaded");
        System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

        final var recommender = appContext.getBean(RecommenderImplementation.class);

        System.out.println(Arrays.toString(recommender.recommendMovies("Nemo")));

        appContext.close();
    }

}
