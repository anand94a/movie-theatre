package com.application.multiplex.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.application.multiplex.controller.Screen;
import com.application.multiplex.converter.MultiplexConverter;
import com.application.multiplex.dao.MultiplexRepository;
import com.application.multiplex.dao.ScreenRepository;
import com.application.multiplex.document.Multiplex;
import com.application.multiplex.dto.MultiplexDto;

@Service
public class MultiplexServiceImpl implements MultiplexService {

	@Autowired
	private MultiplexRepository multiplexRepository;
	
	@Autowired
	private ScreenRepository screenRepository;
	
	@Autowired
	private MultiplexConverter multiplexConverter;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public MultiplexDto addNewMultiplex(MultiplexDto multiplexDto) {
		Multiplex multiplex = multiplexConverter.convertFromDto(multiplexDto);
		Set<Integer> elements = new HashSet<Integer>();
		for(int i=1;i<=multiplex.getNumberOfScreens();i++) {
			elements.add(i);
		}
		multiplex.setSetOfScreens(elements);
		multiplexRepository.save(multiplex);

		return multiplexConverter.convertFromEntity(multiplex);
	}

	@Override
	public List<MultiplexDto> getAllMultiplexLists() {
		List<Multiplex> multiplex = (List<Multiplex>) multiplexRepository.findAll();

		return multiplexConverter.createFromEntities(multiplex);
	}

	@Override
	public MultiplexDto updateMultiplexDetails(MultiplexDto multiplexDto, String multiplexId) {
		Optional<Multiplex> movieOptional = multiplexRepository.findById(multiplexId);
		if (!movieOptional.isPresent()) {
			return null;
		}
		multiplexDto.setMultiplexId(multiplexId);
		Multiplex multiplex = multiplexConverter.convertFromDto(multiplexDto);
		Set<Integer> elements = new HashSet<Integer>();
		for(int i=1;i<=multiplex.getNumberOfScreens();i++) {
			elements.add(i);
		}
		multiplex.setSetOfScreens(elements);
		multiplexRepository.save(multiplex);

		return multiplexConverter.convertFromEntity(multiplex);
	}

	@Override
	public void deleteMultiplexDetails(String multiplexId) {
		multiplexRepository.deleteById(multiplexId);
	}

	@Override
	public MultiplexDto getMultiplexById(String multiplexId) {
		return multiplexConverter.convertFromEntity(multiplexRepository.findById(multiplexId).get());
	}

	@Override
	public MultiplexDto getDetailsByMultiplexName(String multiplexName) {
		Query query = new Query();
		query.addCriteria((Criteria.where("multiplexName").is(multiplexName)));
		query.fields().include("city");
		query.fields().include("numberOfScreens");
		query.fields().include("setOfScreens");
		
		Multiplex multiplex = mongoTemplate.findOne(query, Multiplex.class);
		
		return multiplexConverter.convertFromEntity(multiplex);
	}

	@Override
	public Screen addNewScreen(Screen screen) {
		
		return screenRepository.save(screen);
	}
}
