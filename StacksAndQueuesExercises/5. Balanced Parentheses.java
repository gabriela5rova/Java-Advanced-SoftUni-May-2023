import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> parenthesis = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            String current = Character.toString(input.charAt(i));

            if (current.equals("(") || current.equals("{") || current.equals("[")) {
                parenthesis.push(current);
            } else if (current.equals(")") || current.equals("}") || current.equals("]")) {
                if (parenthesis.isEmpty()) {
                    System.out.println("NO");
                    scanner.close();
                    return;
                }

                String top = parenthesis.pop();
                if ((current.equals(")") && !top.equals("(")) ||
                        (current.equals("}") && !top.equals("{")) ||
                        (current.equals("]") && !top.equals("["))) {
                    System.out.println("NO");
                    scanner.close();
                    return;
                }
            }
        }

        if (parenthesis.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
