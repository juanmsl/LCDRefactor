package persistence;

import java.io.*;

public class FileManager {
    public static BufferedReader createBufferedReader(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        if(inputStreamReader != null) {
            bufferedReader = new BufferedReader(inputStreamReader);
        }
        return bufferedReader;
    }

    public static BufferedReader createBufferedReader(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return createBufferedReader(inputStreamReader);
    }

    public static BufferedReader createBufferedReader(File file) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        return createBufferedReader(fileReader);
    }

    public static BufferedReader createBufferedReader(String fileName) {
        File file = new File(fileName);
        return createBufferedReader(file);
    }

    public static String readLine(BufferedReader bufferedReader) {
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            return null;
        }
        return line;
    }

    public static void closeBufferedReader(BufferedReader bufferedReader) {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            return;
        }
    }

    public static PrintWriter createPrintWriter(OutputStreamWriter outputStreamWriter) {
        PrintWriter printWriter = null;
        if(outputStreamWriter != null) {
            printWriter = new PrintWriter(outputStreamWriter);
        }
        return printWriter;
    }

    public static PrintWriter createPrintWriter(File file) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            return null;
        }
        return createPrintWriter(fileWriter);
    }

    public static PrintWriter createPrintWriter(String filename) {
        File file = new File(filename);
        return createPrintWriter(file);
    }

    public static ObjectInputStream createObjectInputStream(InputStream inputStream) {
        ObjectInputStream objectInputStream = null;
        if(inputStream != null) {
            try {
                objectInputStream = new ObjectInputStream(inputStream);
            } catch (IOException e) {
                return null;
            }
        }
        return objectInputStream;
    }

    public static ObjectInputStream createObjectInputStream(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        return createObjectInputStream(fileInputStream);
    }

    public static ObjectInputStream createObjectInputStream(String filename) {
        File file = new File(filename);
        return createObjectInputStream(file);
    }

    public static Object readObject(ObjectInputStream objectInputStream) {
        try {
            Object object = objectInputStream.readObject();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        return null;
    }

    public static ObjectOutputStream createObjectOutputStream(OutputStream outputStream) {
        ObjectOutputStream objectOutputStream = null;
        if(outputStream != null) {
            try {
                objectOutputStream = new ObjectOutputStream(outputStream);
            } catch (IOException e) {
                return null;
            }
        }
        return objectOutputStream;
    }

    public static ObjectOutputStream createObjectOutputStream(File file) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        return createObjectOutputStream(fileOutputStream);
    }

    public static ObjectOutputStream createObjectOutputStream(String filename) {
        File file = new File(filename);
        return createObjectOutputStream(file);
    }

    public static void writeObject(ObjectOutputStream objectOutputStream, Object object) {
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            return;
        }
    }
}
