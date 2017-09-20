package view;

import controller.LCDController;

public class LCDView {

    private static String[] one = {
            "   ",
            "  |",
            "   ",
            "  |",
            "   ",
    }, two = {
            " - ",
            "  |",
            " - ",
            "|  ",
            " - ",
    }, three = {
            " - ",
            "  |",
            " - ",
            "  |",
            " - ",
    }, four = {
            "   ",
            "| |",
            " - ",
            "  |",
            "   ",
    }, five = {
            " - ",
            "|  ",
            " - ",
            "  |",
            " - ",
    }, six = {
            " - ",
            "|  ",
            " - ",
            "| |",
            " - ",
    }, seven = {
            " - ",
            "  |",
            "   ",
            "  |",
            "   ",
    }, eight = {
            " - ",
            "| |",
            " - ",
            "| |",
            " - ",
    }, nine = {
            " - ",
            "| |",
            " - ",
            "  |",
            " - ",
    }, cero = {
            " - ",
            "| |",
            "   ",
            "| |",
            " - ",
    };

    public static void generateNumber(String number) {
        int columns = LCDController.getTotalColumns(number.length());
        int rows = LCDController.getRows();
        int px = 0;
        char matrix[][] = new char[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = ' ';
            }
        }

        for(int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            String[] digitMatrix = getDigitMatrix(digit);
            addDigit(matrix, digitMatrix, px);
            px += LCDController.getColumns() + LCDController.spaces;
        }
        drawNumber(matrix, rows, columns);
    }

    private static String[] getDigitMatrix(char digit) {
        switch (digit) {
            case '1': return one;
            case '2': return two;
            case '3': return three;
            case '4': return four;
            case '5': return five;
            case '6': return six;
            case '7': return seven;
            case '8': return eight;
            case '9': return nine;
            case '0': return cero;
        }
        return null;
    }

    private static void addDigit(char[][] matrix, String[] digitMatrix, int px) {
        for(int j = px + 1; j <= px + LCDController.size; j++) {
            matrix[0][j] = digitMatrix[0].charAt(1);
            matrix[LCDController.size + 1][j] = digitMatrix[2].charAt(1);
            matrix[LCDController.size * 2 + 2][j] = digitMatrix[4].charAt(1);
        }

        for(int i = 1; i <= LCDController.size; i++) {
            matrix[i][px] = digitMatrix[1].charAt(0);
            matrix[i][px + LCDController.size + 1] = digitMatrix[1].charAt(2);
        }

        for(int i = LCDController.size + 2; i <= LCDController.size * 2 + 1; i++) {
            matrix[i][px] = digitMatrix[3].charAt(0);
            matrix[i][px + LCDController.size + 1] = digitMatrix[3].charAt(2);
        }
    }

    private static void drawNumber(char matrix[][], int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            System.out.println(matrix[i]);
        }
    }
}
