package com.parkease;

import java.time.LocalDateTime;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT)																			
				.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
//	@Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll()) // Allow all requests
//            .csrf((csrf) -> csrf.disable()) // Disable CSRF (use with caution!)
//            .httpBasic().disable() // Disable basic authentication
//            .formLogin().disable() // Disable form login
//            .logout().disable(); // Disable logout
//
//        return http.build();
//    }
}
