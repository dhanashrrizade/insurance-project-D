package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class PolicyDownloaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolicyDownloaderApplication.class, args);
    }
    
    @Bean
    public MaturedPolicyService maturedPolicyService(MaturedPolicyRepository maturedPolicyRepository, ExcelGenerator excelGenerator) {
        return new MaturedPolicyServiceImpl(maturedPolicyRepository, excelGenerator);
    }

    @Bean
    public ExcelGenerator excelGenerator(MaturedPolicyRepository maturedPolicyRepository) {
        return new ExcelGenerator(maturedPolicyRepository);
    }
}
