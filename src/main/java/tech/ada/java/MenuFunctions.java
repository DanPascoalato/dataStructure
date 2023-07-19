package tech.ada.java;

import java.util.*;

public class MenuFunctions {

    public static void insertEmployee(Map<String, List<Employee>> employeeMap) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ano do funcionário:");
        String year = scanner.nextLine();

        System.out.println("Digite o nome do funcionário:");
        String name = scanner.nextLine();

        System.out.println("Digite o cargo do funcionário:");
        String jobTitle = scanner.nextLine();

        System.out.println("Digite o valor do salário base do funcionário:");
        double basePay = parseDoubleInput(scanner.nextLine());

        System.out.println("Digite o valor de horas extras do funcionário:");
        double overtime = parseDoubleInput(scanner.nextLine());

        System.out.println("Digite o valor de outras compensações do funcionário:");
        double otherPay = parseDoubleInput(scanner.nextLine());

        System.out.println("Digite o valor dos benefícios do funcionário:");
        double benefits = parseDoubleInput(scanner.nextLine());

        System.out.println("Digite o valor do salário total do funcionário:");
        double totalPay = parseDoubleInput(scanner.nextLine());

        System.out.println("Digite o valor do salário total com benefícios do funcionário:");
        double totalPayBenefits = parseDoubleInput(scanner.nextLine());

        System.out.println("Digite as observações sobre o funcionário:");
        String notes = scanner.nextLine();

        System.out.println("Digite a agência do funcionário:");
        String agency = scanner.nextLine();

        System.out.println("Digite o status do funcionário (opcional):");
        String status = scanner.nextLine();

        Employee newEmployee = new Employee(0, name, jobTitle, basePay, overtime, otherPay, benefits, totalPay,
                totalPayBenefits, year, notes, agency, status);

        List<Employee> employees = employeeMap.getOrDefault(year, new ArrayList<>());
        employees.add(newEmployee);
        employeeMap.put(year, employees);

        System.out.println("Novo funcionário adicionado:");
        System.out.println(newEmployee);

        scanner.close();
    }

    private static double parseDoubleInput(String input) {
        if (input.isEmpty()) {
            return 0.0; // Valor vazio, atribuir 0.0 como padrão
        } else {
            return Double.parseDouble(input);
        }
    }

    public static void sortEmployeesByYear(Map<String, List<Employee>> employeeMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um ano entre 2011 e 2014 os funcionários:");
        int yearInput = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        String year = String.valueOf(yearInput);

        List<Employee> employees = employeeMap.getOrDefault(year, new ArrayList<>());
        employees.sort(Comparator.comparing(Employee::getName));
        employeeMap.put(year, employees);

        System.out.println("Dados dos funcionários ordenados pelo ano:");
        printTable(employeeMap, year);

        scanner.close();
    }

    public static void removeDuplicateEmployees(Map<String, List<Employee>> employeeMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um ano entre 2011 e 2014 para remover os dados duplicados:");
        String year = scanner.nextLine();

        List<Employee> employees = employeeMap.getOrDefault(year, new ArrayList<>());
        Set<Employee> uniqueEmployees = new HashSet<>(employees);
        employees = new ArrayList<>(uniqueEmployees);
        employeeMap.put(year, employees);

        System.out.println("Dados duplicados removidos.");

        scanner.close();
    }

    public static void searchEmployeeByName(Map<String, List<Employee>> employeeMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um ano entre 2011 e 2014 para pesquisar funcionário:");
        String year = scanner.nextLine();

        List<Employee> employees = employeeMap.getOrDefault(year, new ArrayList<>());

        System.out.println("Digite a substring do nome do funcionário a ser pesquisada:");
        String searchString = scanner.nextLine().toLowerCase();

        Map<String, List<Employee>> invertedIndex = buildInvertedIndex(employees);

        List<Employee> foundEmployees = invertedIndex.getOrDefault(searchString, new ArrayList<>());

        if (!foundEmployees.isEmpty()) {
            System.out.println("Funcionários encontrados:");
            for (Employee employee : foundEmployees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("Nenhum funcionário encontrado.");
        }

        scanner.close();
    }

    private static Map<String, List<Employee>> buildInvertedIndex(List<Employee> employees) {
        Map<String, List<Employee>> invertedIndex = new HashMap<>();

        for (Employee employee : employees) {
            String[] nameParts = employee.getName().toLowerCase().split("\\s+");

            for (String part : nameParts) {
                List<Employee> matchingEmployees = invertedIndex.getOrDefault(part, new ArrayList<>());
                matchingEmployees.add(employee);
                invertedIndex.put(part, matchingEmployees);
            }
        }

        return invertedIndex;
    }


    public static void printTable(Map<String, List<Employee>> employeeMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ano para imprimir a tabela:");
        String year = scanner.nextLine();
        printTable(employeeMap, year);
        scanner.close();
    }

    private static void printTable(Map<String, List<Employee>> employeeMap, String year) {
        System.out.println("Tabela de funcionários do ano " + year + ":");
        List<Employee> employees = employeeMap.getOrDefault(year, new ArrayList<>());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}