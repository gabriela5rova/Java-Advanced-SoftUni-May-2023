import java.util.*;
import java.util.stream.Collectors;

public class steel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputSteel = scanner.nextLine();
        String inputCarbon = scanner.nextLine();
        Queue<Integer> steel = Arrays.stream(inputSteel.split("\\s+")).map((Integer::parseInt))
                .collect(Collectors.toCollection(ArrayDeque::new));
        Stack<Integer> carbon = Arrays.stream(inputCarbon.split("\\s+")).map((Integer::parseInt))
                .collect(Collectors.toCollection(Stack::new));
        Map<String, Integer> sword = new TreeMap<>();
        sword.put("Gladius", 0);
        sword.put("Shamshir", 0);
        sword.put("Katana", 0);
        sword.put("Sabre", 0);

        int forgedSwords = 0;
//first steel and try to mix it with the last carbon.
// If the sum of their values is equal to any of the swords in the table below you
// should forge the sword corresponding to the value and remove both the steel and the carbon.

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int firstSteel = steel.peek();
            int lastCarbon = carbon.peek();
            int sum = firstSteel + lastCarbon;

            if (sum == 70) {
                forgedSwords++;
                steel.poll();
                carbon.pop();
                sword.put("Gladius", sword.get("Gladius") + 1);
            } else if (sum == 80) {
                forgedSwords++;
                steel.poll();
                carbon.pop();
                sword.put("Shamshir", sword.get("Shamshir") + 1);
            } else if (sum == 90) {
                forgedSwords++;
                steel.poll();
                carbon.pop();
                sword.put("Katana", sword.get("Katana") + 1);
            } else if (sum == 110) {
                forgedSwords++;
                steel.poll();
                carbon.pop();
                sword.put("Sabre", sword.get("Sabre") + 1);
            } else {
                steel.poll();
                carbon.pop();
                carbon.push(lastCarbon + 5);
            }

//Otherwise, remove only the steel,
// increase the value of the carbon by 5 and insert it
// back into the collection. You need to stop forging when you have no more steel or carbon left.

        }
        if (forgedSwords != 0) {
            System.out.printf("You have forged %d swords.%n", forgedSwords);
        } else {
            System.out.printf("You did not have enough resources to forge a sword.%n");
        }
if(steel.isEmpty()){
    System.out.println("Steel left: none");
}else{
    System.out.print("Steel left: ");
    System.out.print(steel.toString().replace("[", "").replace("]", ""));
}
        if(carbon.isEmpty()){
            System.out.println("Carbon left: none");
        }else{
            Collections.reverse (carbon);
            System.out.print("Carbon left: ");
            System.out.print(carbon.toString().replace("[", "").replace("]", ""));  //tostring().replace ( target: "[", replacement: '').replace, oldChar: "]" , "");
        }
        System.out.println();
        printMAp((TreeMap<String, Integer>) sword);
    }

    private static void printMAp(TreeMap<String, Integer> sword) {
        for (Map.Entry<String, Integer> entry : sword.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
