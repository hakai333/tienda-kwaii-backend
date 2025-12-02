package cl.MyMGroup.Tienda_Kwaii_backend.Tienda_Kwaii.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desactiva CSRF, importante para POST desde React/Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**", "/admin/**").permitAll() // admin ahora público para desarrollo, mala practica en protectos de verdad
                        .anyRequest().authenticated()            // resto protegido
                )
                .formLogin(form -> form.disable())   // desactiva login form
                .httpBasic(httpBasic -> httpBasic.disable()) // desactiva HTTP Basic
                .logout(logout -> logout.disable()); // desactiva logout automático

        return http.build();
    }
}

