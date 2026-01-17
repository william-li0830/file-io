
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
            letterVal = Codec.wrapChar(letterVal);

            char newChar = Codec.convertBackToChar(letterVal + shift);
            encodedString += newChar;
        }
        System.out.println(encodedString);

        return encodedString;
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
    public void randomizedEncrypter(String fileName) {
        Random rand = new Random();
        int shift = rand.nextInt(Codec.CHAR_RANGE) + 1; // Shift is between [1, 95]

        FileRead fr = new FileRead();
        ArrayList<String> dataList = fr.retrieveDataListFromFile(fileName);
        String newFileName = fileName + "_Encrypted.txt";
        encodeToFile(dataList, newFileName, shift);
    }
}
