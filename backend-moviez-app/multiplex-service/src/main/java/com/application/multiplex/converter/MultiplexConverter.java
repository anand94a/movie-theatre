package com.application.multiplex.converter;

import org.springframework.stereotype.Component;

import com.application.multiplex.document.Multiplex;
import com.application.multiplex.dto.MultiplexDto;

@Component
public class MultiplexConverter extends Converter<MultiplexDto, Multiplex> {

	public MultiplexConverter() {
		super(MultiplexConverter::convertToEntity, MultiplexConverter::convertToDto);
	}

	private static MultiplexDto convertToDto(Multiplex multiplex) {
		return new MultiplexDto(multiplex.getMultiplexId(), multiplex
				.getMultiplexName(),
				multiplex.getCity(), multiplex.getNumberOfScreens(),multiplex.getSetOfScreens());
	}

	private static Multiplex convertToEntity(MultiplexDto dto) {
		return new Multiplex(dto.getMultiplexId(), dto.getMultiplexName(), dto.getCity(),
				dto.getNumberOfScreens(), dto.getSetOfScreens());
	}
}
