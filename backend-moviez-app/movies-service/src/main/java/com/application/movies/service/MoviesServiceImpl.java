package com.application.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.application.movies.converter.MovieConverter;
import com.application.movies.dao.MoviesRepository;
import com.application.movies.document.Movie;
import com.application.movies.dto.MovieDto;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	private MovieConverter movieConverter;

	@Autowired
	private MoviesRepository moviesRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public MovieDto addNewMovie(MovieDto movieDto) {
		Movie movie = movieConverter.convertFromDto(movieDto);
		moviesRepository.save(movie);

		return movieConverter.convertFromEntity(movie);
	}

	@Override
	public List<MovieDto> getAllMoviesList() {
		List<Movie> movie = (List<Movie>) moviesRepository.findAll();

		return movieConverter.createFromEntities(movie);
	}

	@Override
	public MovieDto updateMovieDetails(MovieDto movieDto, String movieId) {
		Optional<Movie> movieOptional = moviesRepository.findById(movieId);
		if (!movieOptional.isPresent()) {
			return null;
		}
		movieDto.setMovieId(movieId);
		Movie movie = movieConverter.convertFromDto(movieDto);
		moviesRepository.save(movie);

		return movieConverter.convertFromEntity(movie);
	}

	@Override
	public void deleteMovieDetails(String movieId) {
		moviesRepository.deleteById(movieId);
	}

	@Override
	public List<MovieDto> getAllMoviesListByName(String name) {
		return null;
	}

	@Override
	public MovieDto getMovieById(String movieId) {
		return movieConverter.convertFromEntity(moviesRepository.findById(movieId).get());
	}

}
