import java.io.*;

public class CopyPasteFile {

    public static int num;
    public CopyPasteFile() throws IOException {
    }



    public static boolean[] loadFile () throws IOException {

        File file = new File("/Users/codecadet/Desktop/paint/paint/src/saveFile.txt");
        FileInputStream inputStream = new FileInputStream(file);
        int fileLength = (int) file.length();
        byte[] data = new byte[fileLength];
        boolean[] output = new boolean[fileLength];
        System.out.println(fileLength);

        inputStream.read(data);
        for (int x = 0; x < data.length; x++)
        {
            if (data[x] != 0)
            {
                System.out.println(x);
                output[x] = true;
                continue;
            }
            output[x] = false;
        }
        inputStream.close();
    return output;
    }

    public static void saveFile( boolean[] gridState) throws IOException
    {
        PrintWriter outputStream = new PrintWriter("/Users/codecadet/Desktop/paint/paint/src/saveFile.txt");


        for (boolean item : gridState)
        {
            outputStream.println(item ? 1 : 0);
            outputStream.flush();
        }
        outputStream.close();
    }



}
