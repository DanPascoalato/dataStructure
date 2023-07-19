package tech.ada.java;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static tech.ada.java.MenuFunctions.*;

public class ShowMenu {
    public static void showMenu(Map<String, List<Employee>> employeeMap) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir novo funcionário");
            System.out.println("2. Ordenar tabela de funcionários por ano");
            System.out.println("3. Remover dados duplicados");
            System.out.println("4. Pesquisar funcionário por nome");
            System.out.println("5. Imprimir tabela de funcionários");
            System.out.println("6. Sair");
            System.out.println("Professor, individualmente todos funcionam mas não sei por que o scanner da erro toda vez que executa um processo e volta para o menu," +
                               "já tentei multipla opções mas nenhuma delas foi, fechei e abri o scanner toda rodada, coloquei condições e tratamento de exceção mas nada resolveu ");

            String choiceInput = scanner.nextLine();

            if (choiceInput.matches("\\d+")) {
                int choice = Integer.parseInt(choiceInput);

                switch (choice) {
                    case 1:
                        insertEmployee(employeeMap);
                        break;
                    case 2:
                        sortEmployeesByYear(employeeMap);
                        break;
                    case 3:
                        removeDuplicateEmployees(employeeMap);
                        break;
                    case 4:
                        searchEmployeeByName(employeeMap);
                        break;
                    case 5:
                        printTable(employeeMap);
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
        System.out.println("Encerrando a aplicação...");
    }
}


