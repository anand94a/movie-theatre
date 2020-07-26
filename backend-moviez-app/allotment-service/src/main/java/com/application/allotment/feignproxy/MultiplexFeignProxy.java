package com.application.allotment.feignproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.application.allotment.document.Multiplex;

@FeignClient("multiplex-service")
@RibbonClient("multiplex-service")
public interface MultiplexFeignProxy {
	
	@GetMapping("multiplex/getDetails/{multiplexName}")
	public ResponseEntity<Multiplex> getDetailsByMultiplexName(@PathVariable("multiplexName") String multiplexName);
	
	
}
