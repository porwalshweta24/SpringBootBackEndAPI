To run the solution, follow these steps:

1. Clone the repository.
2. Set up a compatible Java environment (Java 11 or later).
3. Build the project using Maven: mvn clean install.
4. Run the application: java -jar target/movies-api.jar.
5. Authenticate http://localhost:8080/authenticate and in body params {"username":"user", "password":"user"}
6. Access the API at http://localhost:8080/api/v1/movies with brear token from authenticate API.