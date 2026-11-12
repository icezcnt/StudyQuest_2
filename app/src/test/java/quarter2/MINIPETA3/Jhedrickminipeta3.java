package quarter2.MINIPETA3;

import org.junit.Test;

public class Jhedrickminipeta3 {

    @Test
    public void testFeedbackDetails() {
        String feedback = "This lesson was very informative.";
        int feedbackID = 101;
        String postedDate = "July 20, 2026";

        System.out.println("=== Feedback Details ===");
        System.out.println("Feedback: " + feedback);
        System.out.println("Feedback ID: " + feedbackID);
        System.out.println("Posted On: " + postedDate);
    }

    public static void main(String[] args) {
        new Jhedrickminipeta3().testFeedbackDetails();
    }
}


