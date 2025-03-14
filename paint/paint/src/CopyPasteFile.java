import java.io.*;

public class CopyPasteFile {

    public static int num;

    public CopyPasteFile() throws IOException {
    }

    public static boolean[] loadFile() throws IOException {
        File file = new File("/Users/codecadet/Desktop/paint/paint/src/saveFile.txt");

        if (!file.exists()) {
            System.out.println("Save file not found.");
            return new boolean[0]; // Return empty array if file doesn't exist
        }

        FileInputStream inputStream = new FileInputStream(file);
        int fileLength = (int) file.length();
        boolean[] output = new boolean[fileLength];

        for (int i = 0; i < fileLength; i++) {
            int value = inputStream.read();
            output[i] = (value == '1'); // Read '1' as true, '0' as false
        }

        inputStream.close();
        return output;
    }

    public static void saveFile(boolean[] gridState) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("/Users/codecadet/Desktop/paint/paint/src/saveFile.txt");

        for (boolean item : gridState) {
            outputStream.write(item ? '1' : '0'); // Write '1' for true, '0' for false
        }

        outputStream.close();
    }
}

