package quarter2.MINIPETA3;

import java.util.HashMap;
import java.util.Scanner;

// Removed 'public' so it can run inside Main.java
class Login {

    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("elisha", "pass123");
        users.put("admin", "admin123");

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean loggedIn = false;

        System.out.println("=== LOGIN ===");

        while (attempts < MAX_ATTEMPTS && !loggedIn) {
            System.out.print("Username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (users.containsKey(username) && users.get(username).equals(password)) {
                loggedIn = true;
                System.out.println("Login successful! Welcome, " + username + ".");
            } else {
                attempts++;
                int remaining = MAX_ATTEMPTS - attempts;
                if (remaining > 0) {
                    System.out.println("Invalid username or password. Attempts left: " + remaining);
                }
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Access denied.");
        }

        scanner.close();
    }
}