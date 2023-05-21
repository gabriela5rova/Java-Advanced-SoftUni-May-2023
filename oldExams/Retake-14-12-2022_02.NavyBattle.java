import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] battlefield = new String[n][n];
        List<Integer> tunnelsCoordinates = new ArrayList<>();
        int rowSub = 0;
        int colSub = 0;

        for (int row = 0; row < n; row++) {
            battlefield[row] = scanner.nextLine().split("");
        }

        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield[row].length; col++) {
                String currentEl = battlefield[row][col];

                if (currentEl.equals("S")) {
                    rowSub = row;
                    colSub = col;
                    break; // Optional: If you only want to find the first occurrence, you can break out of the loop.
                }
            }
        }

        boolean missionFailed = false;
        int cruiserSeen = 0;
        int counter = 0;

        while (true) {
            String direction = scanner.nextLine();

            int newRow = rowSub;
            int newCol = colSub;

            switch (direction) {
                case "left":
                    newCol--;
                    break;
                case "right":
                    newCol++;
                    break;
                case "up":
                    newRow--;
                    break;
                case "down":
                    newRow++;
                    break;
            }

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                continue; // Skip the move if it is outside the battlefield
            }

            String movedPlace = battlefield[newRow][newCol];

            if (movedPlace.equals("-")) {
                battlefield[rowSub][colSub] = "-";
                battlefield[newRow][newCol] = "S";
                rowSub = newRow;
                colSub = newCol;
            } else if (movedPlace.equals("*")) {
                counter++;
                battlefield[rowSub][colSub] = "-";
                battlefield[newRow][newCol] = "S";
                rowSub = newRow;
                colSub = newCol;
                if (counter == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", newRow, newCol);
                    missionFailed = true;
                    break;
                }
            } else if (movedPlace.equals("C")) {
                cruiserSeen++;
                battlefield[rowSub][colSub] = "-";
                battlefield[newRow][newCol] = "S";
                rowSub = newRow;
                colSub = newCol;
                if (cruiserSeen == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }
        }

        if (!missionFailed) {
            battlefield[rowSub][colSub] = "S";
        }

        printBattlefield(battlefield);
    }

    private static void printBattlefield(String[][] battlefield) {
        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield[row].length; col++) {
                System.out.print(battlefield[row][col]);
            }
            System.out.println();
        }
    }
}
