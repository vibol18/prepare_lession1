package com.movie.repository;

import com.movie.contract.CrudOperations;
import com.movie.model.Movie;

public interface MovieRepository extends CrudOperations<Movie, Integer> {
}
