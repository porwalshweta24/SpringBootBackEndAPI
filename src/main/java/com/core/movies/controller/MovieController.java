package com.core.movies.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.movies.model.OscarAwards;
import com.core.movies.repository.MovieRepository;
import com.core.movies.constantsUtils.ConstantsStrings;
import com.core.movies.exception.MovieNotFoundException;
import com.core.movies.model.Movie;
import com.core.movies.model.MovieEntity;
import com.core.movies.model.MovieOscarResponse;
import com.core.movies.service.OmdbService;
import com.core.movies.service.OscarService;
import com.opencsv.exceptions.CsvValidationException;


@RestController
@RequestMapping(ConstantsStrings.API_ENDPOINT)
public class MovieController {
	

	@Autowired
	private OmdbService omdbService;
	@Autowired
	private OscarService oscarCsvService;
	@Autowired
	private MovieRepository movieRepository;	
	

	 @GetMapping(ConstantsStrings.BEST_PICTURE_API_ENDPOINT)
	 public ResponseEntity<MovieOscarResponse> getTopRatedBestPictureWinners(
	            @RequestParam("title") String title) throws IOException {

	        

	        // Fetch a single movie from the API
	        Movie movieFromApi = omdbService.fetchMovieByTitleFromApi(title);

	        // Check if the movie was not found
	        if (movieFromApi == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MovieOscarResponse(ConstantsStrings.ERROR_MOVIE_NOT_FOUND, null));
	        }

	        // Read Oscar data from CSV
	        List<OscarAwards> oscarDataList;
	        try {
	            oscarDataList = oscarCsvService.readOscarDataFromCsv();
	        } catch (CsvValidationException | IOException e) {
	            //e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MovieOscarResponse(ConstantsStrings.ERROR_MOVIE_NOT_READING_OSCAR, null));
	        }

	        // Check if the provided movie won an Oscar in any category
	        boolean wonAnyOscar = oscarDataList.stream()
	                .anyMatch(oscarData -> movieFromApi.getTitle().equals(oscarData.getNominee())
	                        && ConstantsStrings.YES.equalsIgnoreCase(oscarData.getWon()));

	        if (!wonAnyOscar) {
	            return ResponseEntity.ok(new MovieOscarResponse(ConstantsStrings.MESSAGE_MOVIE_NOT_WIN, null));
	        }

	        // Check if the provided movie won the "Best Picture" Oscar
	        boolean wonBestPicture = oscarDataList.stream()
	                .anyMatch(oscarData -> ConstantsStrings.BEST_PICTURE.equals(oscarData.getCategory())
	                        && ConstantsStrings.YES.equalsIgnoreCase(oscarData.getWon()) 
	                        && movieFromApi.getTitle().equals(oscarData.getNominee()));

	        // Check if the result matches a specific string
	        String responseString;
	        if (wonBestPicture) {
	        	 // Save movie to the database
	            MovieEntity movieEntity = new MovieEntity();
	            movieEntity.setTitle(movieFromApi.getTitle());
	            movieEntity.setImdbId(movieFromApi.getImdbId());
	            movieEntity.setRating(movieFromApi.getImdbRating());
	            movieEntity.setYear(movieFromApi.getYear());
	            movieEntity.setBoxOffice(movieFromApi.getBoxOffice());
	            // Set other fields as needed
	            saveMovie(movieEntity);
	        //    omdbService.saveBestPictureMovie(movieFromApi);
	            responseString = ConstantsStrings.MESSAGE_MOVIE_WIN_BEST_PICTURE;
	        } else {
	            // Find the category in which the movie won
	            Optional<String> winningCategory = oscarDataList.stream()
	                    .filter(oscarData -> ConstantsStrings.YES.equals(oscarData.getWon())
	                            && movieFromApi.getTitle().equals(oscarData.getNominee()))
	                    .map(OscarAwards::getCategory).findFirst();

	            responseString = ConstantsStrings.MESSAGE_MOVIE_WIN_CATEGORY
	                    + winningCategory.orElse(ConstantsStrings.ERROR_UNKNOWN);
	        }

	        // Create and return the JSON response
	        MovieOscarResponse movieOscarResponse = new MovieOscarResponse(responseString, movieFromApi);
	        return ResponseEntity.ok(movieOscarResponse);
	    }
	 
	 
  //rate only to Best pictures oscar nominated and searched
    @PostMapping(ConstantsStrings.RATE_API_ENDPOINT)
   public ResponseEntity<MovieEntity> rateMovie(
            @RequestParam("title") String title,
            @RequestParam("rating") double rating) {

        // Find the movie by title
        Optional<MovieEntity> optionalMovie = movieRepository.findByTitleIgnoreCase(title);

        if (optionalMovie.isPresent()) {
            // Update the movie's rating
            MovieEntity movie = optionalMovie.get();
            movie.setRating(rating);
            // Save the updated movie
            movieRepository.save(movie);

            return ResponseEntity.ok(movie);
        } else {
            throw new MovieNotFoundException(title);
        }
		
	}

    @GetMapping(ConstantsStrings.TOP_RATE_API_ENDPOINT)
    public ResponseEntity<List<MovieEntity>> getTopRatedMoviesByBoxOffice() {
        List<MovieEntity> topMovies = movieRepository.findTop10ByOrderByBoxOfficeEarningsDesc();
        if (topMovies.isEmpty()) {
            throw new MovieNotFoundException(ConstantsStrings.ERROR_TOP_RATED_MOVIE_NOT_FOUND);
        }
        return ResponseEntity.ok(topMovies);
    }
    
    public void saveMovie(MovieEntity movieEntity) {
        // Check if a movie with the same IMDb ID already exists
        if (!movieRepository.existsByImdbId(movieEntity.getImdbId())) {
            try {
                // Save the movie if it doesn't exist
                movieRepository.saveAndFlush(movieEntity);
            } catch (DataIntegrityViolationException e) {
                // Handle any potential data integrity violations (e.g., concurrent saves)
                // Log or handle the exception as needed
                System.out.println("DataIntegrityViolationException ");

            }
        } else {
            // Handle the case where a movie with the same IMDb ID already exists
            // You may choose to ignore, update, or throw an exception
            System.out.println(ConstantsStrings.MESSAGE_MOVIE_EXISTS + movieEntity.getImdbId());
        }
    }
   
}