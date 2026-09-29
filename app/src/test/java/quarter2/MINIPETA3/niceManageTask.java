package quarter2.MINIPETA3;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

class ManageTask {
    public void taskMenu(Scanner scanner) {
        System.out.println("----- MANAGE TASK -----");
        System.out.println("1. View Default Task");
        System.out.println("2. Enter Custom Task");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                String taskName = "Math Assignment";
                String dueDate = "July 25, 2026";
                boolean isCompleted = false;

                System.out.println("\n=== Manage Task ===");
                System.out.println("Task Name: " + taskName);
                System.out.println("Due Date: " + dueDate);
                System.out.println("Completed: " + isCompleted);
                break;

            case 2:
                System.out.print("Enter task name: ");
                String customTask = scanner.nextLine();

                System.out.print("Enter due date: ");
                String customDate = scanner.nextLine();

                System.out.print("Is it completed? (true/false): ");
                boolean customStatus = scanner.nextBoolean();

                System.out.println("\n=== Manage Task ===");
                System.out.println("Task Name: " + customTask);
                System.out.println("Due Date: " + customDate);
                System.out.println("Completed: " + customStatus);
                break;

            case 3:
                System.out.println("Exiting Manage Task...");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}

public class niceManageTask {
    @Test
    public void testTaskMenu() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("1\n".getBytes()));
        ManageTask taskManager = new ManageTask();

        taskManager.taskMenu(scanner);

        scanner.close();
    }
}
