//package com.example.Export.config;
//
//	import java.util.List;
//
//	 
//
//	import org.springframework.beans.factory.annotation.Value;
//
//	import org.springframework.context.annotation.Bean;
//
//	import org.springframework.context.annotation.Configuration;
//
//	import org.springframework.security.authentication.AuthenticationManager;
//
//	import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//
//	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//	import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//
//	import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.ContentTypeOptionsConfig;
//
//	import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
//
//	import org.springframework.security.crypto.password.PasswordEncoder;
//
//	import org.springframework.security.web.SecurityFilterChain;
//
//	import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy;
//
//	import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
//
//	import org.springframework.web.cors.CorsConfiguration;
//
//	import org.springframework.web.cors.CorsConfigurationSource;
//
//	import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//	 
//
//	@Configuration
//
//	@EnableWebSecurity
//
//	public class SecurityConfig {
//
//
//	 
//
//	    @Bean
//
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//	 
//
//	        return http
//
//	                // .cors(Customizer.withDefaults())
//
//	                .csrf(AbstractHttpConfigurer::disable)
//
//	                .headers(headers -> headers
//
//	                        .cacheControl(cache -> cache.disable())
//
//	                        .contentTypeOptions(ContentTypeOptionsConfig::disable)
//
//	                        .httpStrictTransportSecurity(hsts -> hsts
//
//	                                .includeSubDomains(true)
//
//	                                .preload(true)
//
//	                                .maxAgeInSeconds(31536000))
//
//	                        .frameOptions(FrameOptionsConfig::sameOrigin)
//
//	                        .xssProtection(xss -> xss
//
//	                                .headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK))
//
//	                        .contentSecurityPolicy(csp -> csp
//
//	                                .policyDirectives("'self'"))
//
//	 
//
//	                        .referrerPolicy(referrer -> referrer
//
//	                                .policy(ReferrerPolicy.SAME_ORIGIN)))
//
//	                .build();
//
//	    }
//
//	 
//
//	    @Bean
//
//	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//
//	            throws Exception {
//
//	        return authenticationConfiguration.getAuthenticationManager();
//
//	    }
//
//	 
//
//	    @Bean
//
//	    public PasswordEncoder getPasswordEncoder() {
//
//	        return new BCryptPasswordEncoder();
//
//	    }
//
//	 
//
//	    @Bean
//
//	    CorsConfigurationSource corsConfigurationSource() {
//
//	        CorsConfiguration configuration = new CorsConfiguration();
//
//	        configuration.setAllowedOrigins(List.of("*"));
//
//	        configuration.setAllowedMethods(List.of("GET", "POST"));
//
//	        configuration.setAllowedHeaders(List.of("*"));
//
//	        configuration.setAllowCredentials(true);
//
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//	        source.registerCorsConfiguration("/**", configuration);
//
//	        return source;
//
//	    }
//	    
//
//	}
//
//	 
//
//	 