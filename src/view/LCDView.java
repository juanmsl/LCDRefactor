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

    public static String[] getDigitMatrix(char digit) {
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

    public static void drawNumber(char matrix[][], int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            System.out.println(matrix[i]);
        }
    }
}
