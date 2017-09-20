package controller;

import resources.Strings;
import view.LCDView;

public class LCDController {

    public static int size = 1;
    public static int spaces = 0;

    public static int getColumns() {
        return size + 2;
    }

    public static int getRows() {
        return 2 * size + 3;
    }

    public static int getTotalColumns(int digits) {
        return getColumns() * digits + spaces * (digits - 1);
    }

    public static void Proccess(String line) {

        if(!line.matches("[0-9]*,[0-9]*")) {
            throw new IllegalArgumentException(Strings.ERROR_INVALD_LINE_FORMAT + "\n\t:" + line);
        }

        String[] parameters = line.split(",");

        size = Integer.parseInt(parameters[0]);
        if(size < 1 || 10 < size) {
            throw new IllegalArgumentException(Strings.ERROR_INVALID_SIZE + "\n\t:" + size);
        }

        LCDView.generateNumber(parameters[1]);
    }
}
