package com.application.search.feignproxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.search.model.Allotment;

@FeignClient("allotment-service")
@RibbonClient("allotment-service")
public interface AllotmentFeignProxy {
	@GetMapping("allot/get")
	public ResponseEntity<List<Allotment>> getAllotmentDetails();
}
