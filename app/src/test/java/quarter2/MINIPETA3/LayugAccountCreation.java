package quarter2.MINIPETA3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class Layugminipeta3pt1 {
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

 class Layugminipeta3pt2 {
    private String username;
    private String password;

    public Layugminipeta3pt2(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


class Layugminipeta3pt3 {

    private Map<String, Layugminipeta3pt2> userDatabase = new HashMap<>();


    public boolean registerUser(String username, String password) {
        if (username.isBlank() || password.length() < 4) {
            System.out.println("Invalid input! Password must be at least 4 characters.");
            return false;
        }

        if (userDatabase.containsKey(username)) {
            System.out.println("Registration failed. Username already exists!");
            return false;
        }

        Layugminipeta3pt2 newUser = new Layugminipeta3pt2(username, password);
        userDatabase.put(username, newUser);
        System.out.println("Account successfully created for: " + username);
        return true;
    }


    public boolean loginUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            Layugminipeta3pt2 user = userDatabase.get(username);
            if (user.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome back, " + username + ".");
                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public boolean CurrentUsers(String CurrentUsers) {
        if (userDatabase.isEmpty()) {
            System.out.println("No accounts registered yet.");
            return false;
        }
        System.out.println("Registered Usernames:");
        for (String username : userDatabase.keySet()) {
            System.out.println("-" + username);
        }
        return false;
    }
}


