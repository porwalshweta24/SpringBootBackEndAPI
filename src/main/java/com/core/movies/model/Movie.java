package com.core.movies.model;


import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

	@JsonProperty(value = "Response")
	private String response;
	@JsonProperty(value = "Title")
	private String title;
	@JsonProperty(value = "Year")
	private String year;
	@JsonProperty(value = "Rated")
	private String rated;
	@JsonProperty(value = "Released")
	private String released;
	@JsonProperty(value = "Runtime")
	private String runtime;
	@JsonProperty(value = "Genre")
	private String genre;
	@JsonProperty(value = "Director")
	private String director;
	@JsonProperty(value = "Writer")
	private String writer;
	@JsonProperty(value = "Actors")
	private String actors;
	@JsonProperty(value = "Plot")
	private String plot;
	@JsonProperty(value = "Language")
	private String language;
	@JsonProperty(value = "Country")
	private String country;
	@JsonProperty(value = "Awards")
	private String awards;
	@JsonProperty(value = "Poster")
	private String poster;
	@JsonProperty(value = "Ratings")
	private List<Rating> ratings;
	@JsonProperty(value = "Metascore")
	private String metaScore;
	@JsonProperty(value = "imdbRating")
	private double imdbRating;
	@JsonProperty(value = "imdbVotes")
	private String imdbVotes;
	@JsonProperty(value = "imdbID")
	private String imdbId;
	@JsonProperty(value = "Type")
	private String type;
	@JsonProperty(value = "DVD")
	private String dvd;
	@JsonProperty(value = "BoxOffice")
	private String boxOffice;
	@JsonProperty(value = "Production")
	private String production;
	@JsonProperty(value = "Website")
	private String website;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getBoxOffice() {
		return boxOffice;
	}
	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
    
	

}