package com.example.demo;

// rest of your imports 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MaturedPolicyController {

    private final MaturedPolicyService policyService;
    private final ExcelGenerator excelGenerator;

    @Autowired
    public MaturedPolicyController(@Qualifier("maturedPolicyServiceImpl") MaturedPolicyService policyService,
                                   ExcelGenerator excelGenerator) {
        this.policyService = policyService;
        this.excelGenerator = excelGenerator;
    }

    @GetMapping("/api/matured-policies/download")
    public ResponseEntity<byte[]> downloadMaturedPolicies(
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "policyNumber", required = false) String policyNumber,
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "premiumAmount", required = false) Double premiumAmount) {

        System.out.println("Received download request");

        // Check if parameters are null and provide default values if needed
        if (startDate == null) {
            startDate = LocalDate.of(1900, 1, 1); // or any other default value
        }
        if (endDate == null) {
            endDate = LocalDate.now().plusYears(100); // or any other default value
        }
        // Repeat the same for other parameters if needed

        List<MaturedPolicy> maturedPolicies = policyService.getFilteredMaturedPolicies(startDate, endDate, policyNumber, customerName, premiumAmount);
        System.out.println("Retrieved filtered policies: " + maturedPolicies);

        // Generate Excel file using ExcelGenerator
        byte[] excelBytes = excelGenerator.generateExcel(maturedPolicies);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "matured_policies.xls");

        System.out.println("Download successful");
        return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
    } }