package com.application.multiplex.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.application.multiplex.dto.MultiplexDto;
import com.application.multiplex.service.MultiplexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MultiplexController.class)
public class MultiplexControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MultiplexService service;

	@Test
	public void testAddNewMovie() throws Exception {
		Set<Integer> setOfScreens = new HashSet<>();
		MultiplexDto multiplexDto = new MultiplexDto("1234569", "PVR - Kurla", "Mumbai", 5 , setOfScreens);
		when(service.addNewMultiplex(multiplexDto)).thenReturn(multiplexDto);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/multiplex/create").content(asJsonString(multiplexDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void tesGetAllMoviesList() throws Exception {
		Set<Integer> setOfScreens = new HashSet<>();
		MultiplexDto multiplexDto1 = new MultiplexDto("1234569", "PVR - Kurla", "Mumbai", 5 , setOfScreens);
		MultiplexDto multiplexDto2 = new MultiplexDto("65464564", "PVR - Sion", "Mumbai", 4 , setOfScreens);
		MultiplexDto multiplexDto3 = new MultiplexDto("554456", "PVR - Lower Parel", "Mumbai", 7 , setOfScreens);
		
		List<MultiplexDto> multiplexList = new ArrayList<MultiplexDto>();
		multiplexList.add(multiplexDto1);
		multiplexList.add(multiplexDto2);
		multiplexList.add(multiplexDto3);
		when(service.getAllMultiplexLists()).thenReturn(multiplexList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/multiplex/getall").content(asJsonString(multiplexList))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testGetMovieDetailsById() throws Exception {
		Set<Integer> setOfScreens = new HashSet<>();
		MultiplexDto multiplexDto = new MultiplexDto("1234569", "PVR - Kurla", "Mumbai", 5 , setOfScreens);
		when(service.getMultiplexById(multiplexDto.getMultiplexId())).thenReturn(multiplexDto);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/multiplex/"+multiplexDto.getMultiplexId()).content(asJsonString(multiplexDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testUpdateMovieDetails() throws Exception {
		Set<Integer> setOfScreens = new HashSet<>();
		MultiplexDto multiplexDto = new MultiplexDto("1234569", "PVR - Kurla", "Mumbai", 5 , setOfScreens);
		MultiplexDto newMultiplexDto = new MultiplexDto("1234569", "PVR - Kurla", "Mumbai", 6 , setOfScreens);
		when(service.updateMultiplexDetails(newMultiplexDto, multiplexDto.getMultiplexId())).thenReturn(newMultiplexDto);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/multiplex/update/"+multiplexDto.getMultiplexId()).content(asJsonString(newMultiplexDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testDeleteMovieById() throws Exception {
		Set<Integer> setOfScreens = new HashSet<>();
		MultiplexDto multiplexDto = new MultiplexDto("1234569", "PVR - Kurla", "Mumbai", 5 , setOfScreens);
		MultiplexDto deletedMultiplex = new MultiplexDto();

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/multiplex/delete/"+multiplexDto.getMultiplexId()).content(asJsonString(deletedMultiplex))
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
