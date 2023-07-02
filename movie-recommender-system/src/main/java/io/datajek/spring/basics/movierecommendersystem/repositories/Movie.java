package io.datajek.spring.basics.movierecommendersystem.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Movie {
    private static int instances = 0;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        instances++;
        System.out.println("Movie instance no. " + instances + " created");
    }

    public static int getInstances() {
        return Movie.instances;
    }

    public double movieSimilarity(int movie1, int movie2) {
        double similarity = 0.0;

        //if genres are same add 0.3 to similarity
        //if producers are same add 0.5 to similarity

        return similarity;
    }
}
