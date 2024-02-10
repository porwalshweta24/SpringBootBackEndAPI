The solution is a backend API for fetching the movie by using title from the OMDB API. Key design decisions include API movie object where title compare with CSV nominee to get best picture award. This solution ensures given a movie’s title based on this API and this CSV file that contains winners.


The /best-picture endpoint is designed to determine if a given movie has won the "Best Picture" Oscar. The solution leverages data from both the OMDB API and a CSV file containing Oscar awards information.

Key Design Decisions
Integration with OMDB API:

The solution fetches movie details from the OMDB API using the omdbService.fetchMovieByTitleFromApi method.
CSV Data Processing:

Oscar awards data is obtained from a CSV file through the oscarCsvService.readOscarDataFromCsv method.
Oscar Award Criteria:

The solution checks if the provided movie won the "Best Picture" Oscar based on the values in the "Won" and "Nominee" columns in the CSV data.
Error Handling:

The code includes basic error handling for potential exceptions during CSV data reading.

Example
curl -X GET "http://localhost:8080//api/v1/movies/best-picture?title=TheMovieTitle&csvFilePath=/path/to/academy_awards.csv"

Replace TheMovieTitle with the actual title of the movie and /path/to/academy_awards.csv with the correct path to your CSV file.

Solution contains:
- API
- Solution is able to persist and retrieve data from a real database H2
- API needs to expect an Bearer API token from the caller as user or admin