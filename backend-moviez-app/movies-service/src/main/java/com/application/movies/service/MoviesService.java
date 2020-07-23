package com.application.movies.service;

import java.util.List;

import com.application.movies.dto.MovieDto;

public interface MoviesService {
	
	public MovieDto addNewMovie(MovieDto movie);

	public List<MovieDto> getAllMoviesList();
	
	public MovieDto updateMovieDetails(MovieDto movieDto, String movieIdDto);

	public void deleteMovieDetails(String movieId);

	public List<MovieDto> getAllMoviesListByName(String name);

	public MovieDto getMovieById(String movieId);
	
}
