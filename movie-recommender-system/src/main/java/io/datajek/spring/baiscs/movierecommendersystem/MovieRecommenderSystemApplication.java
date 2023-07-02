package io.datajek.spring.baiscs.movierecommendersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		final var recommender = new RecommenderImplementation();
		final var result = recommender.recommendMovies("Finding Dory");

		System.out.println(Arrays.toString(result));
	}

}
