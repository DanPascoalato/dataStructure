package tech.ada.java;

import java.util.List;
import java.util.Scanner;

import static tech.ada.java.MenuFunctions.*;

public class ShowMenu {

    public static void showMenu(List<Employee> employees) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir novo");
            System.out.println("2. Ordenar tabela");
            System.out.println("3. Eliminação de dados duplicados");
            System.out.println("4. Pesquisar funcionário");
            System.out.println("5. Imprimir tabela");
            System.out.println("6. Sair");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (choice) {
                case 1:
                    displayAllEmployees(employees);
                    break;
                case 2:
                    sortEmployeesByName(employees);
                    break;
                case 3:
                    removeDuplicateEmployees(employees);
                    break;
                case 4:
                    searchEmployeeByName(employees);
                    break;
                case 6:
                    exit = true;
                    break;
                case 5:
                    printTable(employees);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
        System.out.println("Encerrando a aplicação...");
    }
}
