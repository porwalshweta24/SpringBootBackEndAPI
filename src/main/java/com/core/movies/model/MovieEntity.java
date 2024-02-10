package com.core.movies.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.core.movies.constantsUtils.ConstantsStrings;

@Entity
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String imdbId;
    private String title;
    private String boxOffice;
	private double rating;
	private String year;
    private BigDecimal boxOfficeEarnings;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getBoxOffice() {
		return boxOffice;
	}

	 // Additional logic to convert and set boxOfficeEarnings based on boxOffice value
    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
        updateBoxOfficeEarnings();
    }


	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public BigDecimal getBoxOfficeEarnings() {
		return boxOfficeEarnings;
	}

	public void setBoxOfficeEarnings(BigDecimal boxOfficeEarnings) {
		this.boxOfficeEarnings = boxOfficeEarnings;
	} 
	
	private void updateBoxOfficeEarnings() {
	    if (boxOffice != null && boxOffice.matches(ConstantsStrings.REGEX_BOX_OFFICE_EARNING)) {
	            // Remove dollar sign and commas, then parse to BigDecimal
	            String numericValue = boxOffice.replaceAll("\\$|,", "");
	            this.boxOfficeEarnings = new BigDecimal(numericValue);
	        } else {
	            this.boxOfficeEarnings = null;
	        }
	 }
	
}