import java.util.ArrayList;

public class FileDecrypter {
    
    public String decodeString(String encryptedString, int shift) {
        return "";
    }

    public ArrayList<String> decodeData(String[] encryptedStrings, int shift) {
        return null;
    }

    //Tier 2 (decodeFrom =File: reads data from a file, decodes it, and then writes 
    //the decoded information to a new file (hint: you already have all the tools built to do this, you
    //just need to link them together in the right way!)
    public void decodeFromFile(String fileName, int shift, String newFileName) {

        //FileRead to read
        // call decodeData using the read list
        // FileWrite to write to newfile
    }

    public boolean containsRealWord(String phrase)
    {
        FileRead reader = new FileRead();
        
        String[] phraseWords = phrase.split(" "); // Breaks my phrase down into individual words
        ArrayList<String> allWords = reader.retrieveDataListFromFile("AllWords.txt");
        
        boolean foundRealWord = false;
        
        for(String myWord: phraseWords)
        {
            for(String dictWord: allWords)
            {
                if(dictWord.toLowerCase().equals(myWord.toLowerCase()))
                {
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

    public void bruteForceDecryption(){
        
    }
}