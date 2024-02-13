import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class SHA {

    public static String[] possibleHash = new String[10000];
    public static String correctHash = "990547227e9b8f55660f8b46c2005ade8c6fb1c855bf05e16a30f14e156416e2";
    public static String[] array = new String[10000];
    

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        String testPassword = "password not found";
        String salt = getSalt();

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

        //create new list of top 10k most common passwords in hash form
        for(int i = 0; i < array.length; i++) {
            possibleHash[i] = encrypt(array[i]);
        }


        if(args[0].equals("--enc")){
            String enc = encrypt(args[1]);
            System.out.println(enc);
        }

        if(args[0].equals("--encsa")) {
            String enc = get_SHA_256_SecurePassword(args[1], salt);
            System.out.println(enc);
        }

        if(args[0].equals("--break")) {
            for(int i =0; i < possibleHash.length; i++) {
                
                if(possibleHash[i].equals(correctHash)) {
                    testPassword = possibleHash[i];
                    break;
                }
            }
            System.out.println(testPassword);
        } 

        if(args[0].equals("--setPass")) {
            correctHash = encrypt(args[1]);
        }

    }

    private static String encrypt(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    //imported
    private static String get_SHA_256_SecurePassword(String passwordToHash,
            String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }


    // Add salt
    //imported
    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

}

