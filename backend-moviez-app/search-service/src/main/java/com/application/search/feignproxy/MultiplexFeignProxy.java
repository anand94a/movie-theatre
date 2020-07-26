package com.application.search.feignproxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.search.model.Multiplex;

@FeignClient(name="multiplex-service")
@RibbonClient(name="multiplex-service")
public interface MultiplexFeignProxy {
	@GetMapping("multiplex/getall")
	public ResponseEntity<List<Multiplex>> getAllMultiplexList();
}
