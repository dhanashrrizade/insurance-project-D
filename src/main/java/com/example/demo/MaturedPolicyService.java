package com.example.demo;

import java.time.LocalDate;
import java.util.List;

public interface MaturedPolicyService {

    List<MaturedPolicy> getFilteredMaturedPolicies(
            LocalDate startDate, LocalDate endDate, String policyNumber, String customerName, Double premiumAmount);

    void addMaturedPolicy(MaturedPolicy maturedPolicy);

    // Additional methods
    List<MaturedPolicy> getAllMaturedPolicies();

    MaturedPolicy getMaturedPolicyById(Long policyId);

    void updateMaturedPolicy(MaturedPolicy maturedPolicy);

    void deleteMaturedPolicy(Long policyId);

    // ... Add more methods as needed
}
