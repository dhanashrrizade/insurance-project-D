 package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class MaturedPolicy {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // Use lowercase id

	    // ... (other fields and constructors)

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }


    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "maturity_date")
    private LocalDate maturityDate;

    @Column(name = "premium_amount")
    private double premiumAmount;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    // Constructors

    public MaturedPolicy() {
        // Default constructor
    }

    public MaturedPolicy(String policyNumber, String customerName, LocalDate maturityDate, double premiumAmount, LocalDate startDate, LocalDate endDate) {
        this.policyNumber = policyNumber;
        this.customerName = customerName;
        this.maturityDate = maturityDate;
        this.premiumAmount = premiumAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters...

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Override toString() for better logging or debugging

    @Override
    public String toString() {
        return "MaturedPolicy{" +
                "id=" + id +
                ", policyNumber='" + policyNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", maturityDate=" + maturityDate +
                ", premiumAmount=" + premiumAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

}
