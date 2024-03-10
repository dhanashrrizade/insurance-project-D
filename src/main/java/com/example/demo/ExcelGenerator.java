package com.example.demo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ExcelGenerator {

    private final MaturedPolicyRepository maturedPolicyRepository;

    public ExcelGenerator(MaturedPolicyRepository maturedPolicyRepository) {
        this.maturedPolicyRepository = maturedPolicyRepository;
    }

    public byte[] generateExcel(List<MaturedPolicy> policies) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Matured Policies");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Id"); // Add ID column
            headerRow.createCell(1).setCellValue("Policy Number");
            headerRow.createCell(2).setCellValue("Customer Name");
            headerRow.createCell(3).setCellValue("Maturity Date");
            headerRow.createCell(4).setCellValue("Premium Amount");
            headerRow.createCell(5).setCellValue("Start Date");
            headerRow.createCell(6).setCellValue("End Date");

            // Fetch the latest data from the repository
            List<MaturedPolicy> updatedPolicies = maturedPolicyRepository.findAll();

            // Create data rows
            int rowNum = 1;
            for (MaturedPolicy policy : updatedPolicies) {
                if (policy.getEndDate() != null && policy.getEndDate().isEqual(policy.getMaturityDate())) {
                    Row row = sheet.createRow(rowNum++);
                    createCell(row, 0, policy.getId()); // Add ID column
                    createCell(row, 1, policy.getPolicyNumber());
                    createCell(row, 2, policy.getCustomerName());
                    createCell(row, 3, policy.getMaturityDate().toString());
                    createCell(row, 4, policy.getPremiumAmount());
                    createCell(row, 5, policy.getStartDate().toString());
                    createCell(row, 6, policy.getEndDate().toString());
                }
            }

            if (rowNum == 1) {
                // No policies were added, return null or an appropriate response
                return null;
            }

            workbook.write(out);
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
            return null;
        }
    } private void createCell(Row row, int columnIndex, Object value) {
        Cell cell = row.createCell(columnIndex);

        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof LocalDate) {
            cell.setCellValue(((LocalDate) value).toString());
        } else if (value instanceof Long) { // Handle Long data type
            cell.setCellValue((Long) value);
        } else {
            // Handle other data types as needed
            cell.setCellValue(value.toString());
        }
    }


    // Rest of the class remains the same...
}

