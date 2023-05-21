import java.util.Scanner;

public class BlindManBluff {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int nRows = Integer.parseInt(dimensions[0]);
        int mCols = Integer.parseInt(dimensions[1]);
        String[][] playField = new String[nRows][mCols];
        // B - me  ;  O - obstacles  ; P - opponent
        int moves = 0;
        int touchedOpponents = 0;
        int meRow = 0;
        int meCol = 0;

        for (int row = 0; row < nRows; row++) {
            playField[row] = scanner.nextLine().split("\\s+");
        }

        // Find position of "B"
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < mCols; col++) {
                if (playField[row][col].equals("B")) {
                    meRow = row;
                    meCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            int newRow = meRow;
            int newCol = meCol;

            switch (command) {
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

            if (isValidMove(newRow, newCol, nRows, mCols)) {
                String movedPlace = playField[newRow][newCol];
                if (movedPlace.equals("O")) {
                    playField[meRow][meCol] = "B";
                    playField[newRow][newCol] = "O";
                } else if (movedPlace.equals("-")) {
                    moves++;
                    updatePlayerPosition(playField, meRow, meCol, newRow, newCol);
                    meRow = newRow;
                    meCol = newCol;
                } else if (movedPlace.equals("P")) {
                    touchedOpponents++;
                    moves++;
                    updatePlayerPosition(playField, meRow, meCol, newRow, newCol);
                    meRow = newRow;
                    meCol = newCol;
                    if (touchedOpponents == 3) {
                        printGameResult(touchedOpponents, moves);
                        return;
                    }
                }
            }

            command = scanner.nextLine();
        }
        printGameResult(touchedOpponents, moves);
    }

    private static boolean isValidMove(int row, int col, int nRows, int mCols) {
        return row >= 0 && row < nRows && col >= 0 && col < mCols;
    }

    private static void updatePlayerPosition(String[][] playField, int currentRow, int currentCol, int newRow, int newCol) {
        playField[currentRow][currentCol] = "-";
        playField[newRow][newCol] = "B";
    }

    private static void printGameResult(int touchedOpponents, int moves) {
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedOpponents, moves);
    }
}
