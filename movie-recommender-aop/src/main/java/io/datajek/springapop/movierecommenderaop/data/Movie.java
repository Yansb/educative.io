package io.datajek.springapop.movierecommenderaop.data;

import io.datajek.springapop.movierecommenderaop.aspect.MeasureTime;
import org.springframework.stereotype.Repository;

@Repository
public class Movie {
    @MeasureTime
    public String getMovieDetails() {
        return "Movie Details";
    }
}
