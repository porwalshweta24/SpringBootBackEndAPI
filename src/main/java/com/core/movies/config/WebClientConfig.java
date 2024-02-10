package com.core.movies.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${omdb.api.base-url}")
    private String omdbApiUrl;
    
    @Value("${omdb.api.key}") 
    private String apiKey;
 
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder().baseUrl(omdbApiUrl)
                .defaultHeaders(headers -> headers.setBearerAuth(apiKey));
    }

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
    
}