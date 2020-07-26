package com.application.allotment.service;

import java.util.List;

import com.application.allotment.document.Multiplex;
import com.application.allotment.dto.AllotmentDto;

public interface AllotmentService {

	public AllotmentDto saveAllotmentDetails(AllotmentDto dto);

	public List<AllotmentDto> getAllotmentDetails();

//	public List<AllotmentDto> getScreenNumbersOccupiedByMultiplex(String multiplexName);
	
	public Multiplex getScreenNumbersOccupiedByMultiplex(String multiplexName);
}
