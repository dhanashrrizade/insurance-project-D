package com.example.insurance.common;

public class ApiResult {
    private String status;
    private String message;
    private Object data;

    // Default constructor
    public ApiResult() {
    }

    // Constructors with parameters
    public ApiResult(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters and setters
    // (You can generate them in your IDE or write them manually)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
