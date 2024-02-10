package com.core.movies.constantsUtils;

public class ConstantsStrings {
	//End points
    public static final String API_ENDPOINT = "/api/v1/movies";
    public static final String BEST_PICTURE_API_ENDPOINT = "/best-picture";
    public static final String RATE_API_ENDPOINT = "/rate";
    public static final String TOP_RATE_API_ENDPOINT = "/top-rated-by-box-office";
    public static final String AUTHENTICATE_API_ENDPOINT = "/authenticate";
    //errors
    public static final String ERROR_MOVIE_NOT_FOUND = "Movie not found";
    public static final String ERROR_MOVIE_NOT_READING_OSCAR = "Error reading Oscar data";
    public static final String ERROR_TOP_RATED_MOVIE_NOT_FOUND = "Top rated movies not found";
    public static final String ERROR_USER_NOT_FOUND ="User not found with the name ";
    public static final String ERROR_UNKNOWN = "Unknown Category";
    public static final String ERROR_USER_DISABLED ="USER_DISABLED";
    public static final String ERROR_INVALID_CREDENTIALS ="INVALID_CREDENTIALS";
    //message
    public static final String MESSAGE_MOVIE_NOT_WIN = "Movie did not win any Oscar.";
    public static final String MESSAGE_MOVIE_WIN_BEST_PICTURE ="Movie won an Oscar in Best Picture!";
    public static final String MESSAGE_MOVIE_WIN_CATEGORY ="Movie won an Oscar in a different category, i.e.: ";
    public static final String MESSAGE_MOVIE_EXISTS ="Movie with the same IMDb ID already exists: ";
    
    //common
    public static final String YES ="YES";
    public static final String NO ="NO";
    public static final String BEST_PICTURE = "Best Picture";
    
    //path
    public static final String FILE_PATH = "src/main/resources/csv/academy_awards.csv";
    
    //params key
    public static final String TITLE_PARAM =  "t";
    public static final String APIKEY_PARAM =  "apiKey";
    public static final String AUTH_PARAM =  "Authorization";
    public static final String BEARER_PARAM = "Bearer ";

    //roles
    public static final String ROLE_ADMIN =  "ROLE_ADMIN";
    public static final String ROLE_USER =  "ROLE_USER";
    public static final String is_admin =  "isAdmin";
    public static final String is_user =  "isUser";
    public static final String user =  "user";
    public static final String admin =  "admin";
    public static final String ADMIN_PWD =  "$2a$10$0Nv/Qa7m8DdjWpBS2XRZWeP8rWDB7OdScb2grQSRDS9I9fWWlBNG2";
    public static final String USER_PWD ="$2a$10$5VikX1NNQFL9f.N7Ta5wVuBL5HuPi7ro5Q3UZYGVOCURwiotGrVCS";
    
    //REGEX
    public static final String REGEX_BOX_OFFICE_EARNING =  "\\$\\d+(,\\d{3})*(\\.\\d+)?";

}
