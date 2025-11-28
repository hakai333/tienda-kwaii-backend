package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
    * @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

                .csrf(csrf -> csrf.disable()) // Desactiva CSRF

                .cors() // Permite CORS configurado en bean global

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/auth/**").permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/productos/**").permitAll()

                        .anyRequest().authenticated()

                );



        return http.build();

    }
    * */




    // ENCRIPTACION DE CONTRASENA
    @Bean

    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }



    @Bean

    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager(); // Para usar authenticate()

    }

}
