package com.application.movies.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.application.movies.document.Movie;

@Repository
public interface MoviesRepository extends MongoRepository<Movie, String> {

}
