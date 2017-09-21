package view;

import controller.LCDController;

/*
* Class presentation to draw the matrix of characters of the numbers like a LCD screen
* */
public class LCDView {

    /* Static constant base matrix for each number when size is 1 */
    private static final String[] one = {
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

    /*
    * Method that return the corresponding base matrix to the digit recieved
    * @param digit Character of the digit from which its base matrix is returned
    * @return String's array that's the base matrix of the digit recieved
    * */
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

    /*
    * Method that draw the recieved matrix of characters in the console
    * @param matrix Character array that will be printed to the console
    * @param rows Integer that's the number of rows of the matrix
    * @param columns Integer that's the number of columns of the matrix
    * */
    public static void drawNumber(char matrix[][], int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            System.out.println(matrix[i]);
        }
    }
}
