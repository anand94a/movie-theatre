package com.application.allotment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.application.allotment.converter.AllotmentConverter;
import com.application.allotment.dao.AllotmentRepository;
import com.application.allotment.document.Allotment;
import com.application.allotment.document.Multiplex;
import com.application.allotment.dto.AllotmentDto;
import com.application.allotment.feignproxy.MultiplexFeignProxy;

@Service
public class AllotmentServiceImpl implements AllotmentService {

	@Autowired
	private AllotmentRepository allotmentRepository;

	@Autowired
	private AllotmentConverter allotmentConverter;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MultiplexFeignProxy multiplexFeignProxy;

	@Override
	public AllotmentDto saveAllotmentDetails(AllotmentDto dto) {
		Allotment allotment = allotmentConverter.convertFromDto(dto);
		allotmentRepository.save(allotment);

		return allotmentConverter.convertFromEntity(allotment);
	}

	@Override
	public List<AllotmentDto> getAllotmentDetails() {
		List<Allotment> movie = (List<Allotment>) allotmentRepository.findAll();

		return allotmentConverter.createFromEntities(movie);
	}

	@Override
	public Multiplex getScreenNumbersOccupiedByMultiplex(String multiplexName) {
		Query query = new Query();
		query.addCriteria((Criteria.where("multiplexName").is(multiplexName)));
		query.fields().include("multiplexName");
		query.fields().include("screenNumber");

		List<Allotment> allotment = mongoTemplate.find(query, Allotment.class);

		Multiplex multiplex = multiplexFeignProxy.getDetailsByMultiplexName(multiplexName).getBody();

		if (multiplex.getSetOfScreens() != null) {
			for (Allotment allot : allotment) {
				if (multiplex.getSetOfScreens().contains(allot.getScreenNumber())) {
					multiplex.getSetOfScreens().remove(allot.getScreenNumber());
				}
			}
		}
		return multiplex;
	}

}
