package quarter2.MINIPETA3;

import java.util.Scanner;

public class Layugminipeta3pt1 {
    public static void main(String[] args) {
        Layugminipeta3pt3 manager = new Layugminipeta3pt3();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Welcome to the Account System ---");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create Account (Register)");
            System.out.println("2. Log In");
            System.out.println("3. Current Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter new username: ");
                    String regUser = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String regPass = scanner.nextLine();
                    manager.registerUser(regUser, regPass);
                    break;

                case "2":
                    System.out.print("Enter username: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPass = scanner.nextLine();
                    manager.loginUser(loginUser, loginPass);
                    break;

                case "3":
                    System.out.println("Here are the current users");
                    String CurrentUsers = scanner.nextLine();
                    manager.CurrentUsers(CurrentUsers);
                    break;

                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
        scanner.close();
    }
}