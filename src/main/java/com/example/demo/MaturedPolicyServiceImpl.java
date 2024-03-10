package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Service
@Primary
public class MaturedPolicyServiceImpl implements MaturedPolicyService {

    private final MaturedPolicyRepository policyRepository;
    private final ExcelGenerator excelGenerator;

    @Autowired
    public MaturedPolicyServiceImpl(MaturedPolicyRepository policyRepository, ExcelGenerator excelGenerator) {
        this.policyRepository = policyRepository;
        this.excelGenerator = excelGenerator;
    }

    // Constructor to accept List<MaturedPolicy> if needed
    public MaturedPolicyServiceImpl(MaturedPolicyRepository policyRepository, List<MaturedPolicy> maturedPolicies, ExcelGenerator excelGenerator) {
        this.policyRepository = policyRepository;
        this.excelGenerator = excelGenerator;
        // You can use maturedPolicies as needed, for example, for initialization
    }
    @Override
    @Transactional
  
    public List<MaturedPolicy> getFilteredMaturedPolicies(LocalDate startDate, LocalDate endDate, String policyNumber, String customerName, Double premiumAmount) {
        List<MaturedPolicy> maturedPolicies = new ArrayList<>();

        // Fetch policies within the specified date range
        List<MaturedPolicy> policiesInRange = policyRepository.findByMaturityDateBetween(startDate, endDate);

        // Filter policies based on additional criteria if needed
        for (MaturedPolicy policy : policiesInRange) {
            if (matchesPolicyType(policy, policyNumber)
                    && matchesCustomerFilter(policy, customerName)
                    && (premiumAmount == null || policy.getPremiumAmount() == premiumAmount)) {
                maturedPolicies.add(policy);
            }
        }

        // Add logic to print data to Excel for policies within the specified date range
        excelGenerator.generateExcel(maturedPolicies);

        return maturedPolicies;
    }


    @Override
    public void addMaturedPolicy(MaturedPolicy maturedPolicy) {
        policyRepository.save(maturedPolicy);
    }

    @Override
    public List<MaturedPolicy> getAllMaturedPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public MaturedPolicy getMaturedPolicyById(Long policyId) {
        return policyRepository.findById(policyId).orElse(null);
    }


    @Transactional
    @Override
    public void updateMaturedPolicy(MaturedPolicy maturedPolicy) {
        // Implement the logic to update the matured policy in the repository
        // You can use policyRepository.save(maturedPolicy) or your custom logic
        // For simplicity, we are assuming that the ID of the policy is not null
        Long policyId = maturedPolicy.getId();

        if (policyId == null) {
            // Handle the case where the policy doesn't have an ID (new policy creation)
            // You can implement custom logic or throw an exception
            throw new IllegalArgumentException("Cannot update policy without ID.");
        }

        // Check if the policy with the given ID exists in the database
        if (policyRepository.existsById(policyId)) {
            // The policy exists, so save it to update the record
            policyRepository.save(maturedPolicy);
        } else {
            // Handle the case where the policy with the given ID doesn't exist
            // You can implement custom logic or throw an exception
            throw new IllegalArgumentException("Policy with ID " + policyId + " not found.");
        }
    }

    // ...


    @Override
    public void deleteMaturedPolicy(Long policyId) {
        policyRepository.deleteById(policyId);
    }

    // Additional methods can be added here...

    private boolean isWithinDateRange(LocalDate maturityDate, LocalDate startDate, LocalDate endDate) {
        return (startDate == null || maturityDate.isEqual(startDate) || maturityDate.isAfter(startDate))
                && (endDate == null || maturityDate.isEqual(endDate) || maturityDate.isBefore(endDate));
    }

    private boolean matchesPolicyType(MaturedPolicy policy, String policyType) {
        // Assuming policyType is not present in the entity, you can adjust this method accordingly
        return true; // Modify as needed
    }

    private boolean matchesCustomerFilter(MaturedPolicy policy, String customerFilter) {
        return customerFilter == null || customerFilter.equals(policy.getCustomerName());
    }}