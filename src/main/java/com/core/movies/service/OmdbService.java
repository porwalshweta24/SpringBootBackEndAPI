package com.core.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.core.movies.config.WebClientConfig;
import com.core.movies.constantsUtils.ConstantsStrings;
import com.core.movies.interfaces.IOmdbService;
import com.core.movies.model.Movie;


@Service
public class OmdbService implements IOmdbService {

	 @Autowired
	 WebClient.Builder webClientBuilder;
	    
	 @Autowired
	 WebClientConfig config;
	 
	 @Override
	 public Movie fetchMovieByTitleFromApi(String title) {
	    	Movie movie =  webClientBuilder
	    			.build()
	    			.get()
	                .uri(uriBuilder -> uriBuilder
	                        .queryParam(ConstantsStrings.TITLE_PARAM, title)
	                        .queryParam(ConstantsStrings.APIKEY_PARAM, config.getApiKey())
	                        .build())
	                .retrieve()
	                .bodyToMono(Movie.class)
	                .block();
	    	return movie;
	 }
   
}