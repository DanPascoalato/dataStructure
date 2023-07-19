package tech.ada.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadDataFromCSV {
    public static Map<String, List<Employee>> loadDataFromCSV(String csvFilePath, String csvDelimiter) {
        Map<String, List<Employee>> employeeMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] values = line.split(csvDelimiter);
                int id = Integer.parseInt(values[0]);
                String employeeName = values[1];
                String jobTitle = values[2];
                double basePay = parseDouble(values[3]);
                double overtime = parseDouble(values[4]);
                double otherPay = parseDouble(values[5]);
                double benefits = parseDouble(values[6]);
                double totalPay = parseDouble(values[7]);
                double totalPayBenefits = parseDouble(values[8]);
                String year = values[9];
                String notes = values[10];
                String agency = values[11];
                String status = values.length > 12 ? values[12] : ""; // Permitir status vazio

                Employee employee = new Employee(id, employeeName, jobTitle, basePay, overtime, otherPay,
                        benefits, totalPay, totalPayBenefits, year, notes, agency, status);

                List<Employee> employees = employeeMap.getOrDefault(year, new ArrayList<>());
                employees.add(employee);
                employeeMap.put(year, employees);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados do arquivo CSV: " + e.getMessage());
        }

        return employeeMap;
    }

    private static double parseDouble(String value) {
        if (value.isEmpty() || value.equals("Not Provided")) {
            return 0.0; // Valor vazio, atribuir 0.0 como padrão
        } else {
            return Double.parseDouble(value);
        }
    }
}
