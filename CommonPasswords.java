import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class DictionaryAttack {

    private static String correctPassword = "password";


    public static void main(String[] args) throws IOException
    {
        String testPassword = "password not found";


           List<String> listOfStrings
            = new ArrayList<String>();
       
        // load data from file
        BufferedReader bf = new BufferedReader(
            new FileReader("10k-most-common.txt"));
       
        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
       
        // closing bufferreader object
        bf.close();
       
        // storing the data in arraylist to array
        String[] array
            = listOfStrings.toArray(new String[0]);

        // System.out.println("0x" + toHexString(computeMD5("password".getBytes())) + " <== \"" + "password" + "\"");

        for(int i =0; i < array.length; i++) {
            if(correctPassword.equals(array[i])) {
                testPassword = array[i];
                break;
            }
        }

        System.out.println(testPassword);
    }
}
