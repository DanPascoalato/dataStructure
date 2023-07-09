package tech.ada.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadDataFromCSV {

    private static List<Employee> employees = new ArrayList<>();
    public static List<Employee> loadDataFromCSV(String csvFilePath, String csvDelimiter) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvDelimiter);
                String employeeName = values[1];
                String year = values[9];

                employees.add(new Employee(employeeName, year));
            }

            return employees;
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados do arquivo CSV: " + e.getMessage());
        }
        return null;
    }
}
