package tech.ada.java;


import java.util.*;

public class CSVApplication {
    private static final String CSV_FILE_PATH = "D:\\Programa\\MyCode\\src\\main\\java\\resource\\salaries.csv";
    private static final String CSV_DELIMITER = ",";

    public static void main(String[] args) {
        Map<String, List<Employee>> employeeMap = LoadDataFromCSV.loadDataFromCSV(CSV_FILE_PATH, CSV_DELIMITER);
        ShowMenu.showMenu(employeeMap);
    }
}
