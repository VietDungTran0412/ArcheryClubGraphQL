package com.techdes.archery.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Configuration
public class CorsPolicyConfig {
    @Bean
    public CorsConfiguration cors() {
        CorsConfiguration cors = new CorsConfiguration();
        List<String> allowMethods = Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList());
        cors.setAllowedMethods(allowMethods);
        cors.setAllowedOrigins(Arrays.asList("*"));
        cors.setAllowedHeaders(Arrays.asList("*"));
//        cors.setAllowCredentials(true);
        return cors;
    }
    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        FilterRegistrationBean<CharacterEncodingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setFilter(filter);
        return registrationBean;
    }

}
