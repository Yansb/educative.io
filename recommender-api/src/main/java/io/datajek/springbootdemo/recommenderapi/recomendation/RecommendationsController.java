package io.datajek.springbootdemo.recommenderapi.recomendation;

import io.datajek.springbootdemo.recommenderapi.movie.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RecommendationsController {

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return Arrays.asList(
                    new Movie(1, "Ice Age", 7.5),
                    new Movie(2, "Aladdin", 8.5),
                    new Movie(3, "Jumanji", 7.0),
                    new Movie(4, "The Lion King", 8.0),
                    new Movie(5, "Toy Story", 8.5),
                    new Movie(6, "The Avengers", 8.0)
                );
    }
}
