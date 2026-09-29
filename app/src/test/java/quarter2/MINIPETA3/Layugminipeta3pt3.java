package quarter2.MINIPETA3;

import java.util.HashMap;
import java.util.Map;

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