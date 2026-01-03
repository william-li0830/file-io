
import java.util.ArrayList;

public class FileEncrypter {

    FileRead read = new FileRead();
    FileWrite write = new FileWrite();

    public int characterCast(char letter) {
        return (int) letter;
    }

    public char convertBackToChar(int number) {
        return (char) number;
    }

    //Tier 1( improve encodeString method). Wrap back around if the int the char is cast to goes above 126 or below 32
    public void encodeString(String message, int shift) {
        String encodedString = "";

        for (int i = 0; i < message.length(); i++) // Loop as many time as there are letters
        {
            char tempChar = message.charAt(i); // Snag each character from the string one at a time

            // Now, do the converting
            int letterVal = characterCast(tempChar);
            letterVal = wrapValue(letterVal, 32, 126);

            char newChar = convertBackToChar(letterVal + shift);
            encodedString += newChar;
        }
//        return encodedString;

        System.out.println(encodedString);
    }

    // TODO: figure out how this works
    public int wrapValue(int value, int min, int max) {
        if (value > max) {
            return value - max + (min - 1);
        }

        if (value < min) {
            return value - (min - 1) + max;
        }
        return value;
    }

    //Tier 1 (encodeData: accepts a list of Strings, encodes all of them, and returns a list of the encoded content)
    public ArrayList<String> encodeData(String[] data, int shift) {
        ArrayList<String> encodeList = new ArrayList<>();
        return encodeList;
    }

    //encodeToFile: allows data sent to it to be encoded as well as written to a custom file 
    public void encodeToFile(String[] data, int shift, String fileName) {

        //FileWrite 
    }

    //Tier 3 (randomizedEncrypter: randomly generates a cypher/shift key that it 
    //applies to a given file, creating a new file that is a copy of the original except its data is now encrypted
    public void randomizedEncrypter() {

    }
}
