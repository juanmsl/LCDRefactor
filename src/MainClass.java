import controller.LCDController;
import persistence.FileManager;
import resources.Strings;

import java.io.BufferedReader;
import java.util.Vector;

public class MainClass {

    private static Vector<String> lines;

    public static void main(String[] args) {

        try {

            loadLines();

            for (String nextLine : lines) {
                try {
                    LCDController.Proccess(nextLine);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void loadLines() {
        lines = new Vector<>();
        String line = null;
        BufferedReader buffer = FileManager.createBufferedReader(System.in);

        if(buffer != null) {
            System.out.print(Strings.ASK_SPACE_BETWEEN);
            line = FileManager.readLine(buffer);

            try {
                int spaces = Integer.parseInt(line);
                if(0 <= spaces || spaces <= 5) {
                    LCDController.spaces = spaces;
                    System.out.print("Entrada: ");
                    line = FileManager.readLine(buffer);
                    while (!line.equals(Strings.FINAL_INPUT.toString())) {
                        lines.add(line);
                        System.out.print("Entrada: ");
                        line = FileManager.readLine(buffer);
                    }
                } else {
                    throw new IllegalArgumentException(Strings.ERROR_SPACE_BETWEEN);
                }
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException(Strings.ERROR_NOT_A_NUMBER);
            }
        }
    }
}
