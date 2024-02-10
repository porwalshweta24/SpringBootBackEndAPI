package com.core.movies.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.movies.model.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
	
    boolean existsByImdbId(String imdbId);
    Optional<MovieEntity> findByTitleIgnoreCase(String title);
    List<MovieEntity> findTop10ByOrderByBoxOfficeEarningsDesc();

}