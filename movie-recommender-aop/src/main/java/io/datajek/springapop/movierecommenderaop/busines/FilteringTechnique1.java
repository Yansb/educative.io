package io.datajek.springapop.movierecommenderaop.busines;

import io.datajek.springapop.movierecommenderaop.aspect.MeasureTime;
import io.datajek.springapop.movierecommenderaop.data.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilteringTechnique1 {

    @Autowired
    private Movie movie;

    @MeasureTime
    public String contentBasedFiltering() {
        return movie.getMovieDetails();
    }

}
