
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDecrypter {

    public String decodeString(String encryptedString, int shift) {
        String decodedString = "";

        for (int i = 0; i < encryptedString.length(); i++) {
            char tempChar = encryptedString.charAt(i);
            int letterVal = Codec.characterCast(tempChar);
            char newChar = Codec.convertBackToChar(letterVal - shift);

            decodedString += newChar;
        }

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

    //Tier 3 (bruteForceDecryption: It should do the following:
    //Accept an encrypted file
    //Attempt to decrypt the file using a variety of cyphers/shifts
    //Print out each attempt (or a small portion of the content from an attempt, if there is a lot of data) to the user
    //Allow the user to choose if a successful decryption was found in the data.
    //If they choose yes, end the algorithm. If they choose no, run it again with a different set of guesses
    public void bruteForceDecryption(String fileName) {
        Scanner scanner = new Scanner(System.in);

        FileRead fr = new FileRead();
        ArrayList<String> dataList = fr.retrieveDataListFromFile(fileName);

        for (int i = 1; i < Codec.CHAR_RANGE; i++) {
            ArrayList<String> decodedList = decodeData(dataList, i);
            System.out.println("Attempt #" + i);
            System.out.println(decodedList);

            if (!containsRealWord(decodedList)) {
                continue;
            }

            System.out.println("Is this correct? Enter Y for 'YES' or other keys for 'NO'");

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("Success!");
                scanner.close();
                return;
            }
        }

        System.out.println("Failed! Ran out of all possible cyphers");
        scanner.close();
    }

    public boolean containsRealWord(ArrayList<String> phraseList) {
        FileRead reader = new FileRead();

        ArrayList<String> allWords = reader.retrieveDataListFromFile("AllWords.txt");

        for (String phrase : phraseList) {
            String[] phraseWords = phrase.split(" "); // Breaks my phrase down into individual words
            for (String myWord : phraseWords) {
                for (String dictWord : allWords) {
                    if (dictWord.toLowerCase().equals(myWord.toLowerCase())) {
                        System.out.println("Real word found: " + myWord);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
