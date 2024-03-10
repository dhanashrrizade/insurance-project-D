package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<MaturedPolicy> provideMaturedPolicies() {
        // Logic to fetch or generate the list of matured policies
        // For example, you can create some sample data for testing purposes
        List<MaturedPolicy> maturedPolicies = new ArrayList<>();
        // Add your matured policies to the list
        return maturedPolicies;
    }

  
    @Bean
    public ExcelGenerator excelGenerator(MaturedPolicyRepository maturedPolicyRepository) {
        // Initialize and return the ExcelGenerator bean
        return new ExcelGenerator(maturedPolicyRepository);
    }

    @Bean
    public MaturedPolicyServiceImpl maturedPolicyService(MaturedPolicyRepository maturedPolicyRepository, ExcelGenerator excelGenerator) {
        // Use the constructor that takes both MaturedPolicyRepository and ExcelGenerator
        return new MaturedPolicyServiceImpl(maturedPolicyRepository, excelGenerator);
    }
}
