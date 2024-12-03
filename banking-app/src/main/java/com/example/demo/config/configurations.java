package com.example.demo.config;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class configurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        return http.csrf(customizer -> customizer.disable())
//                .authorizeHttpRequests(request-> request.anyRequest().authenticated())
//                .authorizeHttpRequests(request-> request.requestMatchers("teststring","returnname","paramtesting").permitAll()).build();

          return http.csrf(customizer -> customizer.disable()).
                authorizeHttpRequests(request -> request.requestMatchers("/api/accounts/teststring","/api/accounts/returnname/","/api/accounts/Paramtesting").permitAll()
                        .anyRequest().authenticated()).
                httpBasic(Customizer.withDefaults()).build();


    };

}
