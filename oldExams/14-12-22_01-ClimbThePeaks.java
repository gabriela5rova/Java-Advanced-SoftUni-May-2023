import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] foodPortions = scanner.nextLine().split(", ");
        String[] staminaQuantities = scanner.nextLine().split(", ");

        Stack<Integer> foodStack = new Stack<>();
        Queue<Integer> staminaQueue = new LinkedList<>();

        for (String portion : foodPortions) {
            foodStack.push(Integer.parseInt(portion));
        }

        for (String quantity : staminaQuantities) {
            staminaQueue.offer(Integer.parseInt(quantity));
        }

        List<String> conqueredPeaks = new ArrayList<>();

        int[] difficultyLevels = { 80, 90, 100, 60, 70 };
        int peakIndex = 0;

        for (int day = 0; day < 7; day++) {
            if (foodStack.isEmpty() || staminaQueue.isEmpty()) {
                break;
            }

            int foodPortion = foodStack.peek();
            int staminaQuantity = staminaQueue.peek();

            int sum = foodPortion + staminaQuantity;
            int difficultyLevel = difficultyLevels[peakIndex];

            if (sum >= difficultyLevel) {
                conqueredPeaks.add(getPeakName(peakIndex));
                foodStack.pop();
                staminaQueue.poll();
                peakIndex++;

                if (peakIndex == difficultyLevels.length) {
                    break;
                }
            } else {
                foodStack.pop();
                staminaQueue.poll();
                day--;
            }
        }

        if (conqueredPeaks.size() == difficultyLevels.length) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            for (String peak : conqueredPeaks) {
                System.out.println(peak);
            }
        }
    }

    private static String getPeakName(int index) {
        switch (index) {
            case 0:
                return "Vihren";
            case 1:
                return "Kutelo";
            case 2:
                return "Banski Suhodol";
            case 3:
                return "Polezhan";
            case 4:
                return "Kamenitza";
            default:
                return "";
        }
    }
}
