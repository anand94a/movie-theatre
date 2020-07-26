package com.application.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.movies.dto.MovieDto;
import com.application.movies.service.MoviesService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MoviesService moviesService;

	@PostMapping("/create")
	public ResponseEntity<MovieDto> addNewMovie(@RequestBody MovieDto movieDto) {
		MovieDto movie = moviesService.addNewMovie(movieDto);
		ResponseEntity<MovieDto> response = new ResponseEntity<MovieDto>(movie, HttpStatus.OK);
		return response;
	}

	@GetMapping("")
	public ResponseEntity<List<MovieDto>> getAllMoviesList() {
		List<MovieDto> movies = moviesService.getAllMoviesList();
		ResponseEntity<List<MovieDto>> response = new ResponseEntity<List<MovieDto>>(movies, HttpStatus.OK);
		return response;
	}

	@GetMapping("/{movieId}")
	public ResponseEntity<MovieDto> getMovieDetailsById(@PathVariable("movieId") String movieId) {
		MovieDto movies = moviesService.getMovieById(movieId);
		ResponseEntity<MovieDto> response = new ResponseEntity<MovieDto>(movies, HttpStatus.OK);
		return response;
	}

	@PutMapping("/update/{movieId}")
	public ResponseEntity<MovieDto> updateMovieDetails(@RequestBody MovieDto movieDto,
			@PathVariable("movieId") String movieId) {
		MovieDto movies = moviesService.updateMovieDetails(movieDto, movieId);
		ResponseEntity<MovieDto> response = new ResponseEntity<MovieDto>(movies, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/delete/{movieId}")
	public void deleteMovieById(@PathVariable("movieId") String movieId) {
		moviesService.deleteMovieDetails(movieId);
	}

}
