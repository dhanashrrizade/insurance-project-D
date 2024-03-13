package com.example.insurance.api;

import com.example.insurance.model.BranchResponse;
import com.example.insurance.model.NewBranchRequest;
import com.example.insurance.common.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchApiController {

    private static final Logger logger = LoggerFactory.getLogger(BranchApiController.class);

    // In-memory list to store branch details
    private static final List<BranchResponse> branchList = new ArrayList<>();

    // Add some demo data to the in-memory list
    static {
        branchList.add(new BranchResponse(1L, "Mumbai Branch", "Mumbai", "Rahul Sharma", "123-456-7890"));
        branchList.add(new BranchResponse(2L, "Delhi Branch", "Delhi", "Aarti Singh", "987-654-3210"));
        branchList.add(new BranchResponse(3L, "Bangalore Branch", "Bangalore", "Neha Kapoor", "555-123-4567"));
        branchList.add(new BranchResponse(4L, "Chennai Branch", "Chennai", "Raj Kumar", "111-222-3333"));
        branchList.add(new BranchResponse(5L, "Kolkata Branch", "Kolkata", "Priya Gupta", "444-555-6666"));
        branchList.add(new BranchResponse(6L, "Hyderabad Branch", "Hyderabad", "Suresh Reddy", "999-888-7777"));
        branchList.add(new BranchResponse(7L, "Ahmedabad Branch", "Ahmedabad", "Ananya Patel", "333-777-9999"));
        branchList.add(new BranchResponse(8L, "Pune Branch", "Pune", "Amit Deshmukh", "666-111-8888"));
        branchList.add(new BranchResponse(9L, "Jaipur Branch", "Jaipur", "Meera Singh", "222-444-5555"));
        branchList.add(new BranchResponse(10L, "Lucknow Branch", "Lucknow", "Vikram Yadav", "777-999-3333"));
        branchList.add(new BranchResponse(11L, "Chandigarh Branch", "Chandigarh", "Kritika Sharma", "888-666-2222"));
        branchList.add(new BranchResponse(12L, "Indore Branch", "Indore", "Rajat Kapoor", "111-777-5555"));
        branchList.add(new BranchResponse(13L, "Bhopal Branch", "Bhopal", "Anjali Tiwari", "444-999-6666"));
        branchList.add(new BranchResponse(14L, "Surat Branch", "Surat", "Harsh Shah", "555-222-7777"));
        branchList.add(new BranchResponse(15L, "Coimbatore Branch", "Coimbatore", "Sneha Menon", "666-444-1111"));
    }
    @GetMapping("/decor")
    public String getDecorPage() {
        return "decor"; // This assumes that your HTML file is named "decor.html" and is in the "static" folder
    }

    @GetMapping
    public ApiResult handleGetRequest() {
        return new ApiResult("error", "GET method is not supported. Please use POST for adding branches.", null);
    }

    @PostMapping
    public ApiResult addBranch(@RequestBody NewBranchRequest request) {
        try {
            // Validate and process the request
            // Simulate generating a unique branch_id
            Long branchId = (long) (branchList.size() + 1);

            // Create a branch response
            BranchResponse response = new BranchResponse(branchId, request.getName(), request.getLocation(),
                    request.getContactPerson(), request.getContactNumber());

            // Store the branch details in the in-memory list
            branchList.add(response);

            return new ApiResult("success", "Branch details added successfully", response);
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception details for debugging

            // Log the exception using a logging framework (e.g., SLF4J)
            logger.error("Error adding branch details", e);

            return new ApiResult("error", "An unexpected error occurred while adding branch details. Please contact support.", null);
        }
    }

    // Endpoint to retrieve all branches (for demonstration purposes)
    @GetMapping("/all")
    public List<BranchResponse> getAllBranches() {
        return branchList;
    }
}

