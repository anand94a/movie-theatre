package com.application.multiplex.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.application.multiplex.document.Multiplex;

@Repository
public interface MultiplexRepository extends MongoRepository<Multiplex, String> {

}
