package io.datajek.spring.basics.movierecommendersystem.filters;

import io.datajek.spring.basics.movierecommendersystem.movie.Movie;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;

import javax.inject.Named;
import java.util.Objects;

@Named
@Primary
public class ContentBasedFilter implements Filter {
    private static int instances = 0;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Movie movie;

    public ContentBasedFilter(Movie movie) {
        this.movie = Objects.requireNonNull(movie);
        instances++;
        logger.info("In ContentBasedFilter constructor method");
    }

    public static int getInstances() {
        return ContentBasedFilter.instances;
    }

    public String[] getRecommendations(String movie) {
        // logic of content based filter
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }

    public Movie getMovie() {
        return movie;
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("In ContentBasedFilter postConstruct method..");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("In ContentBasedFilter preDestroy method..");
    }
}
