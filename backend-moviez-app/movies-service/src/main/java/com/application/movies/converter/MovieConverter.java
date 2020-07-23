package com.application.movies.converter;

import org.springframework.stereotype.Component;

import com.application.movies.document.Movie;
import com.application.movies.dto.MovieDto;

@Component
public class MovieConverter extends Converter<MovieDto, Movie> {

	public MovieConverter() {
		super(MovieConverter::convertToEntity, MovieConverter::convertToDto);
	}

	private static MovieDto convertToDto(Movie movie) {
		return new MovieDto(movie.getMovieId(), movie.getMovieName(), movie.getMovieCategory(), movie.getProducer(),
				movie.getDirector(), movie.getReleaseDate());
	}

	private static Movie convertToEntity(MovieDto dto) {
		return new Movie(dto.getMovieId(), dto.getMovieName(), dto.getMovieCategory(), dto.getProducer(),
				dto.getDirector(), dto.getReleaseDate());
	}

}
