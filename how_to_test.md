To test the service, perform the following:

Testing Scenarios
Positive Test Case: Movie Won "Best Picture"
localhost:8080/movies/best-picture
if you use postman then add in body title and csvFilePath  to run GET API

Provide the title of a movie that won the "Best Picture" Oscar. 
Verify that the endpoint returns true.
curl -X GET "http://localhost:8080/api/v1/movies/best-picture?title=TheGodfather&csvFilePath=/path/to/academy_awards.csv"

Negative Test Case: Movie Did Not Win "Best Picture"
Provide the title of a movie that did not win the "Best Picture" Oscar.
Verify that the endpoint returns false.
curl -X GET "http://localhost:8080/api/v1/movies/best-picture?title=SpiderMan&csvFilePath=/path/to/academy_awards.csv"

Error Case: Invalid CSV File
Provide a valid movie title and an invalid CSV file path.
Verify that the endpoint handles the error gracefully (e.g., logs the error).
curl -X GET "http://localhost:8080/api/v1/movies/best-picture?title=TheMovieTitle&csvFilePath=/invalid/path/academy_awards.csv"

Error Case: Invalid Movie Title
Provide an invalid movie title and a valid CSV file path.
Verify that the endpoint handles the error gracefully (e.g., logs the error).
curl -X GET "http://localhost:8080/api/v1/movies/best-picture?title=InvalidMovieTitle&csvFilePath=/path/to/academy_awards.csv"

Same for 
localhost:8080/api/v1/movies/rate
if you use postman then add in body title and rating to run POST API

localhost:8080/api/v1/movies/top-rated-by-box-office
if you use postman then add nothing to run GET API


