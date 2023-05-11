import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split("\\s+");
ArrayDeque<String> stack = new ArrayDeque<>();

        for (String number : inputArr) {
            stack.push(number);
        }

        while(!stack.isEmpty()){
            String element = stack.pop();
            System.out.print(element +" ");
        }
    }
}
