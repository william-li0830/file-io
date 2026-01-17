
import java.io.File;
import java.util.ArrayList;

public class FileDecrypter {

    public String decodeString(String encryptedString, int shift) {
        String decodedString = "";

        for (int i = 0; i < encryptedString.length(); i++) {
            char tempChar = encryptedString.charAt(i);
            int letterVal = Codec.characterCast(tempChar);
            char newChar = Codec.convertBackToChar(letterVal - shift);

            decodedString += newChar;
        }

        System.out.println(decodedString);
        return decodedString;
    }

    //Tier 2:
    public ArrayList<String> decodeData(ArrayList<String> data, int shift) {
        ArrayList<String> decodedList = new ArrayList<>();

        for (String encrypted : data) {
            String decoded = decodeString(encrypted, shift);
            decodedList.add(decoded);
        }
        
        return decodedList;
    }

    //Tier 2 (decodeFrom =File: reads data from a file, decodes it, and then writes 
    //the decoded information to a new file (hint: you already have all the tools built to do this, you
    //just need to link them together in the right way!)
    public void decodeFromFile(String fileName, String newFileName, int shift) {
        FileRead fr = new FileRead();

        ArrayList<String> dataList = fr.retrieveDataListFromFile(fileName);
        ArrayList<String> decodedList = decodeData(dataList, shift);

        FileWrite fw = new FileWrite();
        fw.writeContentsToFile(newFileName, decodedList, false);
    }
    //FileRead to read
    // call decodeData using the read list
    // FileWrite to write to newfile

    public boolean containsRealWord(String phrase) {
        FileRead reader = new FileRead();

        String[] phraseWords = phrase.split(" "); // Breaks my phrase down into individual words
        ArrayList<String> allWords = reader.retrieveDataListFromFile("AllWords.txt");

        boolean foundRealWord = false;

        for (String myWord : phraseWords) {
            for (String dictWord : allWords) {
                if (dictWord.toLowerCase().equals(myWord.toLowerCase())) {
                    foundRealWord = true;
                    break;
                }
            }
        }

        return foundRealWord;
    }

//Tier 3 (bruteForceDecryption: It should do the following:
//Accept an encrypted file
//Attempt to decrypt the file using a variety of cyphers/shifts
//Print out each attempt (or a small portion of the content from an attempt, if there is a lot of data) to the user
//Allow the user to choose if a successful decryption was found in the data.
//If they choose yes, end the algorithm. If they choose no, run it again with a different set of guesses
    public void bruteForceDecryption(String fileName, String newFileName, int shift) {

        FileRead fr = new FileRead();
//        fr.readFromFile(fileName);

        FileEncrypter fileEncrypter = new FileEncrypter();

        int length = 0;

        File file = new File(fileName);

        for (int i = 0; i < file.length(); i++) {
//            String encrypted = encryptedStrings.get(i);
            String decoded = "";
//            for (int c = 0; c < encrypted.length(); c++) {
//                char tempChar = encrypted.charAt(c);
//                int letterVal = fileEncrypter.characterCast(tempChar);
//                char newChar = fileEncrypter.convertBackToChar(letterVal - shift);
//                decoded += newChar;
        }
//            decodedFile.add(decoded);
    }
//        Scanner scan = new Scanner();
//        scan.nextLine();

    String input;

//        if (input = "yes") {
//            System.out.println("Successful");
//        } else {
//            System.out.println("Unsucssesful");
//        }
}
//    }
