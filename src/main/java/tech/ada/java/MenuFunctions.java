package tech.ada.java;

import java.util.*;

public class MenuFunctions {

    public static void displayAllEmployees(List<Employee> employees) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do funcionário:");
        String name = scanner.nextLine();

        System.out.println("Digite o ano do funcionário:");
        String year = scanner.nextLine();

        Employee newEmployee = new Employee(name, year);
        employees.add(newEmployee);

        System.out.println("Novo funcionário adicionado:");
        System.out.println(newEmployee);

        scanner.close();
    }


    public static void sortEmployeesByName(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Dados dos funcionários ordenados por nome:");
        displayAllEmployees(employees);
    }

    public static void removeDuplicateEmployees(List<Employee> employees) {
        Set<Employee> uniqueEmployees = new HashSet<>(employees);
        employees = new ArrayList<>(uniqueEmployees);
        System.out.println("Dados duplicados removidos.");
    }

    public static void searchEmployeeByName(List<Employee> employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do funcionário a ser pesquisado:");
        String name = scanner.nextLine();

        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                System.out.println("Funcionário encontrado:");
                System.out.println(employee);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void printTable(List<Employee> employees) {
        System.out.println("Tabela de funcionários:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
