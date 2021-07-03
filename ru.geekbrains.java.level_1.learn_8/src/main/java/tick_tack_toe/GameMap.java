package tick_tack_toe;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class GameMap extends JFrame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static int scoreHuman;
    private static int scoreAI;


//    public static void main(String[] args) {
//        while (true) {
//            playRound();
//            System.out.printf("SCORE IS: HUMAN   AI\n            %d     %d\n", scoreHuman, scoreAI);
//            System.out.print("Wanna play again? Y or N >>> ");
//            if (!SCANNER.next().toLowerCase().equals("y")) break;
//        }
//    }

    private static void playRound() {
        initField(3, 3);
        printField();
        while (true) {
            humanTurn();
            printField();
            if (gameCheck(DOT_HUMAN)) break;
            aiTurn();
            printField();
            if (gameCheck(DOT_AI)) break;
        }
    }

    private static boolean gameCheck(char dot) {
        if (checkDraw()) {
            System.out.println("DRAW!!!");
            return true;
        }

        if (checkWin(dot)) {
            if (dot == DOT_HUMAN) {
                System.out.println("HUMAN wins!!!");
                scoreHuman++;
            } else {
                System.out.println("AI wins!!!");
                scoreAI++;
            }
            return true;
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char dot) {
        int count = 0;
        //Horizontal
        for (int y = 0; y < fieldSizeY; y++) {
            count = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == dot) {
                    count++;
                }
            }
            if (count == fieldSizeX) return true;
        }

        //Vertical
        for (int x = 0; x < fieldSizeX; x++) {
            count = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == dot) {
                    count++;
                }
            }
            if (count == fieldSizeY) return true;
        }

        //Diagonal
        for (int y = 0, x = 0; y < fieldSizeY && x < fieldSizeX; y++, x++) {
            if (field[y][x] == dot) {
                count++;
            }

            if (count == fieldSizeX && count == fieldSizeY) return true;

        }
        count = 0;
        for (int y = 0, x = fieldSizeX - 1; y < fieldSizeY && x >= 0; y++, x--) {
            if (field[y][x] == dot) {
                count++;
            }

            if (count == fieldSizeX && count == fieldSizeY) return true;

        }

        return false;
    }


    private static void aiTurn() {
        int x = 0;
        int y = 0;

        for (int i = 0; i < 5; i++) {
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isCellEmpty(y, x));

            if (checkWin(DOT_AI)) {
                field[y][x] = DOT_AI;
                return;
            }
        }
        field[y][x] = DOT_AI;

    }

    private static void humanTurn() {
        int x, y;

        do {
            System.out.print("Please enter coordinates of your turn x & y with whitespace >>>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(y, x) || !isCellEmpty(y, x));

        field[y][x] = DOT_HUMAN;
    }

    private static boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

    public static void initField(int sizeY, int sizeX) {
        fieldSizeY = sizeY;
        fieldSizeX = sizeX;
        field = new char[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    public static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX * 2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
