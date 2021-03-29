package homework4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static int scoreHuman = 0;
    private static int scoreAI = 0;

    public static int cntTurns = 0;

    public static void main(String[] args) {
        fieldSizeY = 5;
        fieldSizeX = 5;
        do {
            initField();
            printField();

            while (true) {
                humanTurn();
                printField();
                /* 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов. */
                if (gameCheck(DOT_HUMAN, "Вы победили!")) break;
                aiTurn();
                printField();
                /* 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов. */
                if (gameCheck(DOT_AI, "Компьютер победил!")) break;
            }
            System.out.printf("Счет игры:\nВы: %d || AI: %d\n", scoreHuman, scoreAI);
            System.out.println("Повторить? Y или N");
        } while (SCANNER.next().equalsIgnoreCase("y"));
    }

    /* 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов. */
    private static boolean checkWin(char c) {
        boolean checkHoriz;
        boolean checkVert;
        int l = field.length;

        for (int y = 0; y < l; y++) {
            checkHoriz = true;
            checkVert = true;
            int x;
            for (x = 0; x < l; x++) {
                checkHoriz &= (field[x][y] == c);
                checkVert &= (field[y][x] == c);
            }
            if (checkVert || checkHoriz) return true;
        }

        boolean checkDiagRight = true;
        boolean checkDiagLeft = true;
        for (int i = 0; i < l; i++) {
            checkDiagRight &= field[i][i] == c;
            checkDiagLeft &= field[i][l - 1 - i] == c;
        }
        return checkDiagLeft || checkDiagRight;
    }

    private static void initField() {
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }
        for (int i = 0; i <= fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты х и у через пробел: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
        cntTurns++;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));

        field[y][x] = DOT_AI;
        cntTurns++;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    private static boolean gameCheck(char dot, String s) {
        if (checkWin(dot)) {
            if (dot == DOT_HUMAN) {
                scoreHuman++;
            } else {
                scoreAI++;
            }
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья.");
            return true;
        }
        return false;
    }
}