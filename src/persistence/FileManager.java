package persistence;

import java.io.*;

/*
* Class to manage the streams of files or data transfer
* */
public class FileManager {

    /*
    * Method that create a BufferedReader
    * @param inputStreamReader InputStreamReader to create the BufferedReader
    * @return BufferedReader if is possible to create, or null otherwise
    * */
    public static BufferedReader createBufferedReader(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        if(inputStreamReader != null) {
            bufferedReader = new BufferedReader(inputStreamReader);
        }
        return bufferedReader;
    }

    /*
    * Method that create a BufferedReader
    * @param inputStream InputStream to create the BufferedReader
    * @return BufferedReader if is possible to create, or null otherwise
    * */
    public static BufferedReader createBufferedReader(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return createBufferedReader(inputStreamReader);
    }

    /*
    * Method that create a BufferedReader
    * @param file File to create the BufferedReader
    * @return BufferedReader if is possible to create, or null otherwise
    * */
    public static BufferedReader createBufferedReader(File file) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        return createBufferedReader(fileReader);
    }

    /*
    * Method that create a BufferedReader
    * @param fileName String that is the path of the file to create the BufferedReader
    * @return BufferedReader if is possible to create, or null otherwise
    * */
    public static BufferedReader createBufferedReader(String fileName) {
        File file = new File(fileName);
        return createBufferedReader(file);
    }

    /*
    * Method that read the next line of a BufferedReader
    * @param bufferedReader BufferedReader that will be used for read the next line
    * @return String The line read from the buffer, or null if the buffer not contains any more lines to read
    * */
    public static String readLine(BufferedReader bufferedReader) {
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            return null;
        }
        return line;
    }

    /*
    * Method that close the stream of a bufferedReader
    * @param bufferedReader BufferedReader that will be closed
    * */
    public static void closeBufferedReader(BufferedReader bufferedReader) {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            return;
        }
    }

    /*
    * Method that create a PrintWriter
    * @param outputStreamWriter OutputStreamWriter to create the PrintWriter
    * @return PrintWriter if is possible to create, or null otherwise
    * */
    public static PrintWriter createPrintWriter(OutputStreamWriter outputStreamWriter) {
        PrintWriter printWriter = null;
        if(outputStreamWriter != null) {
            printWriter = new PrintWriter(outputStreamWriter);
        }
        return printWriter;
    }

    /*
    * Method that create a PrintWriter
    * @param file File to create the PrintWriter
    * @return PrintWriter if is possible to create, or null otherwise
    * */
    public static PrintWriter createPrintWriter(File file) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            return null;
        }
        return createPrintWriter(fileWriter);
    }

    /*
    * Method that create a PrintWriter
    * @param fileName String that is the path of the file to create the PrintWriter
    * @return PrintWriter if is possible to create, or null otherwise
    * */
    public static PrintWriter createPrintWriter(String filename) {
        File file = new File(filename);
        return createPrintWriter(file);
    }

    /*
    * Method that create a ObjectInputStream
    * @param inputStream InputStream to create the ObjectInputStream
    * @return ObjectInputStream if is possible to create, or null otherwise
    * */
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

    /*
    * Method that create a ObjectInputStream
    * @param file File to create the ObjectInputStream
    * @return ObjectInputStream if is possible to create, or null otherwise
    * */
    public static ObjectInputStream createObjectInputStream(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        return createObjectInputStream(fileInputStream);
    }

    /*
    * Method that create a ObjectInputStream
    * @param fileName String that is the path of the file to create the ObjectInputStream
    * @return ObjectInputStream if is possible to create, or null otherwise
    * */
    public static ObjectInputStream createObjectInputStream(String fileName) {
        File file = new File(fileName);
        return createObjectInputStream(file);
    }

    /*
    * Method that read an object from a ObjectInputStream
    * @param objectInputStream ObjectInputStream that will be used to read the object
    * */
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

    /*
    * Method that create a ObjectOutputStream
    * @param outputStream OutputStream to create the ObjectOutputStream
    * @return ObjectOutputStream if is possible to create, or null otherwise
    * */
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

    /*
    * Method that create a ObjectOutputStream
    * @param file File to create the ObjectOutputStream
    * @return ObjectOutputStream if is possible to create, or null otherwise
    * */
    public static ObjectOutputStream createObjectOutputStream(File file) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        return createObjectOutputStream(fileOutputStream);
    }

    /*
    * Method that create a ObjectOutputStream
    * @param fileName String that is the path of the file to create the ObjectOutputStream
    * @return ObjectOutputStream if is possible to create, or null otherwise
    * */
    public static ObjectOutputStream createObjectOutputStream(String fileName) {
        File file = new File(fileName);
        return createObjectOutputStream(file);
    }

    /*
    * Method that read an object from a ObjectOutputStream
    * @param objectOutputStream ObjectOutputStream that will be used to write the object
    * @param oject Object that will be write throught the objectOutputStream
    * */
    public static void writeObject(ObjectOutputStream objectOutputStream, Object object) {
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            return;
        }
    }
}
