package com.core.movies.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import java.io.File;

import com.core.movies.constantsUtils.ConstantsStrings;
import com.core.movies.interfaces.IOscarService;
import com.core.movies.model.OscarAwards;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class OscarService implements IOscarService {

    
	@Override
	public List<OscarAwards> readOscarDataFromCsv() throws IOException, CsvValidationException {
	    List<OscarAwards> oscarDataList = new ArrayList<>();
	    
        String filePath = ConstantsStrings.FILE_PATH;

	    try (CSVReader csvReader = new CSVReader(new FileReader(new File(filePath)))) {
	        // Read and ignore headers
	        String[] headers = csvReader.readNext();
	        
	        // Read each line of the CSV file
	        String[] nextRecord;
	        while ((nextRecord = csvReader.readNext()) != null) {
	            // Create a new OscarAwards object for each record
	            OscarAwards oscarData = new OscarAwards();
	            
	            // Set values from the CSV record to the OscarAwards object
	            oscarData.setYear(nextRecord[0]);
	            oscarData.setCategory(nextRecord[1]);
	            oscarData.setNominee(nextRecord[2]);
	            oscarData.setAdditionalInfo(nextRecord[3]);
	            
	            // Set the "Won" field, assuming it is at index 4 (change if needed)
	            oscarData.setWon(nextRecord[4]);
	            
	            // Add the OscarAwards object to the list
	            oscarDataList.add(oscarData);
	        }
	    }

	    return oscarDataList;
	}


}