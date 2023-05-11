import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        N S X  -   N-> num of el to add  S-> num of el to poll   X->  check if present

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int currentMin = Integer.MAX_VALUE;

        while (queue.size()<commands[0] ){
            for (Integer number : numbers) {
                queue.add(number);
            }}
            for (int j = 0; j < commands[1]; j++) {
                queue.poll();
                if (queue.isEmpty()) {
                    System.out.println(0);
                    return;
                }
            }

        if (queue.contains(commands[2])) {
            System.out.println("true");
        } else {
            for (int num : numbers) {
                // Update the current minimum if a smaller element is found
                if (num < currentMin) {
                    currentMin = num;
                }
            }
            System.out.println(currentMin);


        }
    }
}
