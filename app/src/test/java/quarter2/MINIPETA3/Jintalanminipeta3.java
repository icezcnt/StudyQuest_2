package quarter2.MINIPETA3;

import org.junit.Test;
import java.util.HashMap;

public class Jintalanminipeta3 {

    @Test
    public void testLogin() {
        HashMap<String, String> users = new HashMap<>();
        users.put("elisha", "pass123");
        users.put("admin", "admin123");

        System.out.println("=== LOGIN TEST ===");
        System.out.println("Checking users...");
        if (users.containsKey("elisha")) {
            System.out.println("User 'elisha' found.");
        }
    }
}
