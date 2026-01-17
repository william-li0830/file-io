
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class FileEncrypter {


    //Tier 1( improve encodeString method). Wrap back around if the int the char is cast to goes above 126 or below 32
    public String encodeString(String message, int shift) {
        String encodedString = "";

        for (int i = 0; i < message.length(); i++) // Loop as many time as there are letters
        {
            char tempChar = message.charAt(i); // Snag each character from the string one at a time

            // Now, do the converting
            int letterVal = Codec.characterCast(tempChar);
            letterVal = wrapValue(letterVal, 32, 126);

            char newChar = Codec.convertBackToChar(letterVal + shift);
            encodedString += newChar;
        }
        System.out.println(encodedString);
        
        return encodedString;
    }

    // Example:
    // wrapValue(13, 2, 5)
    //      range = 5 - 2 + 1 = 4
    //      shiftedValue = 13 - 2 = 11
    //      wrapped = 11 % 4 = 3
    //      final = 3 + 2 = 5
    public int wrapValue(int value, int min, int max) {
        // gets how many values is in between min and max
        int range = max - min + 1;
        // shifts the value so min becomes 0
        int shiftedValue = value - min;
        // gets the remainder using modulo
        int wrapped = shiftedValue % range;
        // shifts back to original range
        return wrapped + min;
    }

    //Tier 1 (encodeData: accepts a list of Strings, encodes all of them, and returns a list of the encoded content)
    public ArrayList<String> encodeData(ArrayList<String> data, int shift) {
        ArrayList<String> encodeList = new ArrayList<>();

        for (String message : data) {
            String encodedString = encodeString(message, shift);
            encodeList.add(encodedString);
        }
        return encodeList;
    }

    //encodeToFile: allows data sent to it to be encoded as well as written to a custom file 
    public void encodeToFile(ArrayList<String> data, String newFileName, int shift) {
        ArrayList<String> encodedList = encodeData(data, shift);

        FileWrite fw = new FileWrite();
        fw.writeContentsToFile(newFileName, encodedList, false);
    }

    //Tier 3 (randomizedEncrypter: randomly generates a cypher/shift key that it 
    //applies to a given file, creating a new file that is a copy of the original except its data is now encrypted
    public void randomizedEncrypter(String fileName, String updatedFileName) {
        Random rand = new Random();
        int shift = rand.nextInt(26);

        FileRead fr = new FileRead();
        FileWrite fw = new FileWrite();
        
        String encoded = "";
        
        fr.readFromFile(fileName);
        
       File file = new File(fileName);
       
       int length = 0;

        for (int i = 0; i < file.length(); i++) {
//            String encrypted = encryptedStrings.get(i);
//            for (int c = 0; c < encrypted.length(); c++) {
//                char tempChar = encrypted.charAt(c);
//                int letterVal = characterCast(tempChar);
//                char newChar = convertBackToChar(letterVal + shift);
//                encoded += newChar;
            }
        }
//        fw.writeContentsToFile(fileName, updatedFileName, false);
     }
//}