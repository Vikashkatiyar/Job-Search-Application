# JobSearchApplication

## Technologies
- Java
- Spring Boot
- Spring Data JPA
- Spring MVC
- Spring Actuator
- Docker
- Docker Compose (Spring 3.1)
- H2 Database (for local development)
- PostgreSQL Database (For production)

## Modules

### 1. Companies
- Lists all the company names providing jobs
- Includes company reviews

### 2. Job Module
- Contains attributes: `Long id`, `String title`, `String description`, `String minSalary`, `String maxSalary`, `String location`
- Lists jobs associated with a company

### 3. Review Module
- Connected with a company
- Attributes: `Long id`, `String title`, `String description`, `double rating`
- Multiple reviews per company

## API Testing
- Done using POSTMAN tool
- # All EndPoints:
![image](https://github.com/Vikashkatiyar/FirstJobApplication/assets/89769715/67b7088d-9d99-4f7b-b99c-81cc59327671)

## How to Run
1. Ensure Java and Docker are installed.
2. Clone the repository.
3. Build and run using Docker Compose:
    ```
    docker-compose up
    ```
4. Access the application at [http://localhost:8080](http://localhost:8080)

## API Documentation
- Refer to the provided API documentation for detailed information on endpoints and usage.

## Note
- Make sure to configure the database connection details in the application properties file.
- For local development, the H2 database is used. For production, consider configuring a PostgreSQL database.

Feel free to contribute and improve this project!

## Project Author
Vikash Katiyar



