package com.application.allotment.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.application.allotment.document.Allotment;

@Repository
public interface AllotmentRepository extends MongoRepository<Allotment, String>{

}
