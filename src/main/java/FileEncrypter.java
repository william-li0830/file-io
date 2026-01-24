import java.util.ArrayList;
import java.util.Random;

public class FileEncrypter {

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

    public void randomizedEncrypter(String fileName) {
        Random rand = new Random();
        int shift = rand.nextInt(Codec.CHAR_RANGE - 1) + 1; // Shift is between [1, 94]

        System.out.println("Encrypt with cypher " + shift);
        FileRead fr = new FileRead();
        ArrayList<String> dataList = fr.retrieveDataListFromFile(fileName);
        String newFileName = fileName + "_Encrypted.txt";
        encodeToFile(dataList, newFileName, shift);
    }

    public String layeredEncrytion(String message) {
        String encodedString = "";
        for (int i = 0; i < message.length(); i++) {
            char tempChar = message.charAt(i);
            int letterVal = Codec.characterCast(tempChar);
            
        if (i % 2 == 0) {
            letterVal += 2;
        }
        letterVal +=3;
        
            char newChar = Codec.convertBackToChar(letterVal);
            encodedString += newChar;
        }
        System.out.println(encodedString);
        return encodedString;
    }
}