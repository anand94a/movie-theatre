package com.application.allotment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.allotment.document.Multiplex;
import com.application.allotment.dto.AllotmentDto;
import com.application.allotment.service.AllotmentService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/allot")
public class AllotmentController {
	
	@Autowired
	private AllotmentService allotmentService;
	
	@PostMapping("/add")
	public ResponseEntity<AllotmentDto> saveAllotmentDetails(@RequestBody AllotmentDto dto){
		AllotmentDto allot = allotmentService.saveAllotmentDetails(dto);
		return new ResponseEntity<AllotmentDto>(allot, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<AllotmentDto>> getAllotmentDetails(){
		List<AllotmentDto> allotment = allotmentService.getAllotmentDetails();
		ResponseEntity<List<AllotmentDto>> response = new ResponseEntity<List<AllotmentDto>>(allotment, HttpStatus.OK);
		return response;
	}
	
//	@GetMapping("/getScreen/{multiplexName}")
//	public ResponseEntity<List<AllotmentDto>> getScreenNumbersOccupiedByMultiplex(@PathVariable("multiplexName") String multiplexName){
//		List<AllotmentDto> allotment = allotmentService.getScreenNumbersOccupiedByMultiplex(multiplexName);
//		ResponseEntity<List<AllotmentDto>> response = new ResponseEntity<List<AllotmentDto>>(allotment, HttpStatus.OK);
//		return response;
//	}
	
	@GetMapping("/getScreen/{multiplexName}")
	public ResponseEntity<Multiplex> getScreenNumbersOccupiedByMultiplex(@PathVariable("multiplexName") String multiplexName){
		Multiplex allotment = allotmentService.getScreenNumbersOccupiedByMultiplex(multiplexName);
		ResponseEntity<Multiplex> response = new ResponseEntity<Multiplex>(allotment, HttpStatus.OK);
		return response;
	}
	
}
