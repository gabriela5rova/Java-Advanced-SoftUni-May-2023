import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); // number of commands

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] input = line.split("\\s+");
            int command = Integer.parseInt(input[0]);

            if (command == 1) {
                int numberToPush = Integer.parseInt(input[1]);
                numbers.push(numberToPush);
                currentMax = Math.max(currentMax, numberToPush);
            } else if (command == 2) {
                int poppedElement = numbers.pop();
                if (poppedElement == currentMax) {
                    currentMax = Integer.MIN_VALUE;
                    for (int num : numbers) {
                        currentMax = Math.max(currentMax, num);
                    }
                }
            } else if (command == 3) {
                System.out.println(currentMax);
            }
        }
    }
}
