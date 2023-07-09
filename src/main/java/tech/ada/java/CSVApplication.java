package tech.ada.java;

import java.util.*;

public class CSVApplication {
    private static final String CSV_FILE_PATH = "D:\\Programa\\dataset\\salaries.csv";
    private static final String CSV_DELIMITER = ",";

    public static void main(String[] args) {
        List<Employee> employees = LoadDataFromCSV.loadDataFromCSV(CSV_FILE_PATH, CSV_DELIMITER);
        ShowMenu.showMenu(employees);
    }

}
