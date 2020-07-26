package com.application.allotment.converter;

import org.springframework.stereotype.Component;

import com.application.allotment.document.Allotment;
import com.application.allotment.dto.AllotmentDto;

@Component
public class AllotmentConverter extends Converter<AllotmentDto, Allotment> {

	public AllotmentConverter() {
		super(AllotmentConverter::convertToEntity, AllotmentConverter::convertToDto);
	}

	private static AllotmentDto convertToDto(Allotment allotment) {
		return new AllotmentDto(allotment.getAllotmentId(), allotment.getMovieName(), allotment.getMultiplexName(),
				allotment.getCity(), allotment.getScreenNumber());
	}

	private static Allotment convertToEntity(AllotmentDto dto) {
		return new Allotment(dto.getAllotmentId(), dto.getMovieName(), dto.getMultiplexName(), dto.getCity(),
				dto.getScreenNumber());
	}

}
