package com.application.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.search.feignproxy.AllotmentFeignProxy;
import com.application.search.feignproxy.MultiplexFeignProxy;
import com.application.search.model.Allotment;
import com.application.search.model.Multiplex;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private MultiplexFeignProxy multiplexFeignProxy;
	
	@Autowired
	private AllotmentFeignProxy allotmentFeignProxy;

	@GetMapping("/multiplex")
	public ResponseEntity<List<Multiplex>> getAllMultiplexDetails() {
		List<Multiplex> multiplex = multiplexFeignProxy.getAllMultiplexList().getBody();
		return new ResponseEntity<List<Multiplex>>(multiplex, HttpStatus.OK);
	}
	
	@GetMapping("/allotment")
	public ResponseEntity<List<Allotment>> getAllotmentDetails() {
		List<Allotment> allotment = allotmentFeignProxy.getAllotmentDetails().getBody();
		return new ResponseEntity<List<Allotment>>(allotment, HttpStatus.OK);
	}
}
