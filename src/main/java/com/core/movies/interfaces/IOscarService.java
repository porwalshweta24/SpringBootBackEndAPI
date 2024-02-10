package com.core.movies.interfaces;

import java.io.IOException;
import java.util.List;

import com.core.movies.model.OscarAwards;
import com.opencsv.exceptions.CsvValidationException;

public interface IOscarService {
	
	public List<OscarAwards> readOscarDataFromCsv() throws IOException, CsvValidationException; 

}
