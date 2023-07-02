package io.datajek.spring.baiscs.movierecommendersystem;

import io.datajek.spring.baiscs.movierecommendersystem.filters.CollaborativeFilter;
import io.datajek.spring.baiscs.movierecommendersystem.filters.ContentBasedFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		final var recommender = new RecommenderImplementation(new CollaborativeFilter());
		final var result = recommender.recommendMovies("Finding Dory");

		System.out.println(Arrays.toString(result));
	}

}
