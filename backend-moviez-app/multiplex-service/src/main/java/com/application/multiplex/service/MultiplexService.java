package com.application.multiplex.service;

import java.util.List;

import com.application.multiplex.controller.Screen;
import com.application.multiplex.dto.MultiplexDto;

public interface MultiplexService {

	public MultiplexDto addNewMultiplex(MultiplexDto multiplexDto);

	public List<MultiplexDto> getAllMultiplexLists();

	public MultiplexDto updateMultiplexDetails(MultiplexDto multiplexDto, String multiplexId);

	public void deleteMultiplexDetails(String movieId);

	public MultiplexDto getMultiplexById(String multiplexId);

	public MultiplexDto getDetailsByMultiplexName(String multiplexName);

	public Screen addNewScreen(Screen screen);

}
