package com.application.movies.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.application.movies.dto.MovieDto;
import com.application.movies.service.MoviesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MovieController.class)
public class MovieControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MoviesService service;

	@Test
	public void testAddNewMovie() throws Exception {
		MovieDto movieDto = new MovieDto("1234569", "Dhamaal", "Comedy", "Pankaj", "Roy", "");
		when(service.addNewMovie(movieDto)).thenReturn(movieDto);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/movies/create").content(asJsonString(movieDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void tesGetAllMoviesList() throws Exception {
		MovieDto movie1 = new MovieDto("1234569", "Dhamaal", "Comedy", "Pankaj", "Roy", "Jun 15, 2000");
		MovieDto movie2 = new MovieDto("454654567", "Lagaan", "Thriller", "Ramesh", "Khalid", "Apr 16 2020");
		MovieDto movie3= new MovieDto("78554", "Gangajal", "Action", "N Modi", "A Shah", "May 25 2000");
		List<MovieDto> moviesList = new ArrayList<MovieDto>();
		moviesList.add(movie1);
		moviesList.add(movie2);
		moviesList.add(movie3);
		when(service.getAllMoviesList()).thenReturn(moviesList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movies/").content(asJsonString(moviesList))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testGetMovieDetailsById() throws Exception {
		MovieDto movie = new MovieDto("1234569", "Dhamaal", "Comedy", "Pankaj", "Roy", "Jun 15, 2000");
		when(service.getMovieById(movie.getMovieId())).thenReturn(movie);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movies/"+movie.getMovieId()).content(asJsonString(movie))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testUpdateMovieDetails() throws Exception {
		MovieDto movie = new MovieDto("1234569", "Dhamaal", "Comedy", "Pankaj", "Roy", "Jun 15, 2000");
		MovieDto newMovie = new MovieDto("1234569", "Dhamaal", "Comedy", "Harish", "Roy", "Jun 15, 2000");
		when(service.updateMovieDetails(newMovie, movie.getMovieId())).thenReturn(newMovie);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/movies/update/"+movie.getMovieId()).content(asJsonString(newMovie))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testDeleteMovieById() throws Exception {
		MovieDto movie = new MovieDto("1234569", "Dhamaal", "Comedy", "Pankaj", "Roy", "Jun 15, 2000");
		MovieDto deletedMovie = new MovieDto();

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/movies/delete/"+movie.getMovieId()).content(asJsonString(deletedMovie))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	public static String asJsonString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			System.out.println("Exception in JSON String conversion");
		}
		System.out.println("Json String : " + jsonString);
		return jsonString;
	}
}
