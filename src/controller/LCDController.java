package controller;

import resources.Strings;
import view.LCDView;

/*
* Class controller to generate the needed matrix of characters to display the numbers like a LCD screen
* */
public class LCDController {

    /* Static variable for size of the number */
    public static int size = 1;

    /* Static variable for spaces between digits */
    public static int spaces = 0;

    /*
    * Method to get the needed columns to build a digit
    * @return Integer - number of columns
    * */
    public static int getColumns() {
        return size + 2;
    }

    /*
    * Method to get the needed rows to build a digit
    * @return Integer - number of columns
    * */
    public static int getRows() {
        return 2 * size + 3;
    }

    /*
    * Method to get the needed columns to build a number with the spaces, between digits
    * @param digit Integer that's the number of digits
    * @return Integer - number of columns
    * */
    public static int getTotalColumns(int digits) {
        return getColumns() * digits + spaces * (digits - 1);
    }

    /*
    * Method to proccess the command line recieved, it get the size and the number to proccess from the command line
    * separated by comma.
    * @param line String that's the command line, and the format is 'size,number'
    * */
    public static void Proccess(String line) {

        // Verifing if the line command recieved matches with the format (####,####)
        if(!line.matches("[0-9]*,[0-9]*")) {
            throw new IllegalArgumentException(Strings.ERROR_INVALD_LINE_FORMAT + "\n\t:" + line);
        }

        // Getting the size and the number to proccess
        String[] parameters = line.split(",");

        // Verifing if the size is between 1 and 10
        size = Integer.parseInt(parameters[0]);
        if(size < 1 || 10 < size) {
            throw new IllegalArgumentException(Strings.ERROR_INVALID_SIZE + "\n\t:" + size);
        }

        // Getting the needed rows and columns to generate de number
        int rows = getRows();
        int columns = getTotalColumns(parameters[1].length());

        // Generating the matrix number
        char matrix[][] = generateNumber(parameters[1], rows, columns);

        // Drawing the number
        LCDView.drawNumber(matrix, rows, columns);
    }

    /*
     * Method that generate the characters matrix of the number
     * @param number String that's the number to generate
     * @param rows Integer that's the number of rows for the matrix
     * @param columns Integer that's the number of columns for the matrix
     * @return Characters matrix, wich contains the generated number
     */
    public static char[][] generateNumber(String number, int rows, int columns) {
        // Instanciate the matrix and the current position for each digit
        char matrix[][] = new char[rows][columns];
        int currentColumn = 0;

        // Initialazing the matrix with spaces
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = ' ';
            }
        }

        // Filling the matrix
        for(int i = 0; i < number.length(); i++) {
            // Add the current digit to the matrix
            char digit = number.charAt(i);
            addDigit(digit, matrix, currentColumn);

            // Move the current column for the next digit
            currentColumn += LCDController.getColumns() + LCDController.spaces;
        }

        return matrix;
    }

    /*
    * Method that add a digit to the recieved matrix
    * @param digit Character to add to the matrix
    * @param matric Character matrix where the digit will be added
    * @currentColumn Integer that's the current column of the matrix where the digit will be added
    * */
    public static void addDigit(char digit, char[][] matrix, int currentColumn) {
        // Get the basic matrix for the digit
        String[] digitMatrix = LCDView.getDigitMatrix(digit);

        // Add the '-' character of the digit to the matrix
        for(int j = currentColumn + 1; j <= currentColumn + LCDController.size; j++) {
            matrix[0][j] = digitMatrix[0].charAt(1);
            matrix[LCDController.size + 1][j] = digitMatrix[2].charAt(1);
            matrix[LCDController.size * 2 + 2][j] = digitMatrix[4].charAt(1);
        }

        // Add the '|' character of the top of the digit to the matrix
        for(int i = 1; i <= LCDController.size; i++) {
            matrix[i][currentColumn] = digitMatrix[1].charAt(0);
            matrix[i][currentColumn + LCDController.size + 1] = digitMatrix[1].charAt(2);
        }

        // Add the '|' character of the bottom of the digit to the matrix
        for(int i = LCDController.size + 2; i <= LCDController.size * 2 + 1; i++) {
            matrix[i][currentColumn] = digitMatrix[3].charAt(0);
            matrix[i][currentColumn + LCDController.size + 1] = digitMatrix[3].charAt(2);
        }
    }
}
