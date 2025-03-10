/**
 * This class configures Spring Security settings for the application.
 * It handles authentication, authorization, and CORS configuration.
 *
 * @author [Albert Ondicho]
 */

package codebaze.co.ke.Introduction_To_SpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * This class sets up security configuration for a Spring Boot app.
 * */
@Configuration // Tells Spring this is a configuration class
@EnableWebSecurity // Enables Spring Security for the app
public class ApplicationConfiguration {

    /**
     * List of URLs that don’t need authentication (open to all).
     */
    public static final String[] WHITELIST_URLS = {
            "/api/**" // Allows all URLs starting with /api/
    };

    /**
     * Sets up CORS (Cross-Origin Resource Sharing) to allow requests from any source.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*")); // Allows all origins
        configuration.setAllowedMethods(Arrays.asList("*")); // Allows all HTTP methods (GET, POST, etc.)
        configuration.setAllowedHeaders(Arrays.asList("*")); // Allows all headers
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Applies to all paths
        return source;
    }

    /**
     * Configures security rules, like which URLs are public or protected.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return
                http
                        .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enables CORS with above settings
                        .csrf(AbstractHttpConfigurer::disable) // Disables CSRF protection (common for APIs- Common API attack)
                        .authorizeHttpRequests(request -> {
                            request.requestMatchers(WHITELIST_URLS).permitAll(); // Whitelisted URLs don’t need login
                            request.anyRequest().authenticated(); // All other URLs require authentication
                        }).build(); // Builds the security configuration
    }
}