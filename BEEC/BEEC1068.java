import java.util.Scanner;

public class BEEC1068 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String expression = scanner.nextLine();
            int openCount = 0;
            boolean incorrect = false;

            for (int i = 0; i < expression.length(); i++) {
                char character = expression.charAt(i);
                if (character == ')') {
                    if (openCount == 0) {
                        incorrect = true;
                        break;
                    }
                    openCount--;
                } else if (character == '(') {
                    openCount++;
                }
            }
            if (incorrect || openCount > 0) {
                System.out.println("incorrect");
            } else {
                System.out.println("correct");
            }
        }
    }
}
