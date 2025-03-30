package com.kalanden.api_gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Allow frontend URL
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow HTTP methods
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization", "Origin", "Accept")); // Allow headers
        config.setExposedHeaders(Arrays.asList("Authorization")); // Expose headers if needed (e.g. for JWT)
        source.registerCorsConfiguration("/**", config); // Apply to all routes
        return new CorsFilter(source);
    }
}

