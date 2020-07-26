package com.application.multiplex.controller;

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

import com.application.multiplex.dto.MultiplexDto;
import com.application.multiplex.service.MultiplexService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/multiplex")
public class MultiplexController {
	
	@Autowired
	MultiplexService multiplexService;
	
	@PostMapping("/create")
	public ResponseEntity<MultiplexDto> addNewMultiplex(@RequestBody MultiplexDto multiplexDto) {
		MultiplexDto multiplex = multiplexService.addNewMultiplex(multiplexDto);
		ResponseEntity<MultiplexDto> response = new ResponseEntity<MultiplexDto>(multiplex, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<MultiplexDto>> getAllMultiplexList() {
		List<MultiplexDto> multiplex = multiplexService.getAllMultiplexLists();
		ResponseEntity<List<MultiplexDto>> response = new ResponseEntity<List<MultiplexDto>>(multiplex, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/{multiplexId}")
	public ResponseEntity<MultiplexDto> getMultiplexDetailsById(@PathVariable("multiplexId") String multiplexId) {
		MultiplexDto multiplex = multiplexService.getMultiplexById(multiplexId);
		ResponseEntity<MultiplexDto> response = new ResponseEntity<MultiplexDto>(multiplex, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/update/{multiplexId}")
	public ResponseEntity<MultiplexDto> updateMultiplexDetails(@RequestBody MultiplexDto multiplexDto, @PathVariable("multiplexId") String multiplexId) {
		MultiplexDto multiplex = multiplexService.updateMultiplexDetails(multiplexDto, multiplexId);
		ResponseEntity<MultiplexDto> response = new ResponseEntity<MultiplexDto>(multiplex, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/delete/{multiplexId}")
	public void deleteMultiplexById(@PathVariable("multiplexId") String multiplexId) {
		multiplexService.deleteMultiplexDetails(multiplexId);
	}
	
	@GetMapping("/getDetails/{multiplexName}")
	public ResponseEntity<MultiplexDto> getDetailsByMultiplexName(@PathVariable("multiplexName") String multiplexName){
		MultiplexDto multiplex = multiplexService.getDetailsByMultiplexName(multiplexName);
		ResponseEntity<MultiplexDto> response = new ResponseEntity<MultiplexDto>(multiplex, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/saveScreen")
	public ResponseEntity<Screen> addNewScreen(@RequestBody Screen screen) {
		Screen newScreen = multiplexService.addNewScreen(screen);
		ResponseEntity<Screen> response = new ResponseEntity<Screen>(newScreen, HttpStatus.OK);
		return response;
	}
	
}
