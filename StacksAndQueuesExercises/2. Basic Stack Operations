import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStacOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//[N, S, X] N->number of elements to push  S-> number of elements to pop  X->element to check if present
        Integer toDelete = numbers[1];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int currentMin = Integer.MAX_VALUE;
        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        while (stack.size() < numbers[0]) {
            for (int element : elements) {
                stack.push(element);
            }
        }
        for (int i = 0; i < toDelete; i++) {
            stack.pop();
            if (stack.isEmpty()) {
                System.out.println(0);
                return;
            }
        }
        if (stack.contains(numbers[2])) {
            System.out.println("true");
        } else {
            for (int num : stack) {
                // Update the current minimum if a smaller element is found
                if (num < currentMin) {
                    currentMin = num;
                }
            }
            System.out.println(currentMin);
        }
    }
}








