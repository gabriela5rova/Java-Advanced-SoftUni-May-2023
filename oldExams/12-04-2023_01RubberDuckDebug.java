import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> taskTimes = new LinkedList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        Stack<Integer> taskNumbers = new Stack<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(taskNumbers::push);

        int darthVaderDuck = 0;
        int thorDuck = 0;
        int blueDuck = 0;
        int yellowDuck = 0;

        while (!taskTimes.isEmpty() && !taskNumbers.isEmpty()) {
            int currentTime = taskTimes.poll();
            int currentTask = taskNumbers.pop();

            int totalTaskTime = currentTask * currentTime;

            if (totalTaskTime <= 60) {
                darthVaderDuck++;
            } else if (totalTaskTime <= 120) {
                thorDuck++;
            } else if (totalTaskTime <= 180) {
                blueDuck++;
            } else if (totalTaskTime <= 240) {
                yellowDuck++;
            } else {
                taskTimes.offer(currentTime);
                taskNumbers.push(currentTask - 2);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%nThor Ducky: %d%nBig Blue Rubber Ducky: %d%nSmall Yellow Rubber Ducky: %d%n",
                darthVaderDuck, thorDuck, blueDuck, yellowDuck);
    }
}
