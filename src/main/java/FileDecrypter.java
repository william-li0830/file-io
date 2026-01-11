import java.util.ArrayList;

public class FileDecrypter {
    
    public String decodeFromString(String encryptedString, int shift) {
         String decodedString = "";
        
        for(int i = 0; i < encryptedString.length(); i++) // Loop as many time as there are letters
        {
            char tempChar = encryptedString.charAt(i); // Snag each character from the string one at a time
            
            // Now, do the converting       
            FileEncrypter fileEncrypter = new FileEncrypter();
            
            int letterVal = fileEncrypter.characterCast(tempChar);
            char newChar = fileEncrypter.convertBackToChar(letterVal - shift);
            decodedString += newChar;
        }
        System.out.println(decodedString);
        return "";
    }
    
    //Tier 2:

    public ArrayList<String> decodeList(String[] encryptedStrings, int shift) {
    
    ArrayList<String> decodedList = new ArrayList<String>();
    
    FileEncrypter fileEncrypter = new FileEncrypter();
    
        for(int i = 0; i<encryptedStrings.length; i++){
            String encrypted = encryptedStrings[i];
            String decoded = "";
            for(int c = 0; c<encrypted.length(); c++){
                char tempChar = encrypted.charAt(c);
                int letterVal = fileEncrypter.characterCast(tempChar);
                char newChar = fileEncrypter.convertBackToChar(letterVal - shift);
                decoded += newChar;
                decodedList.add(decoded);
                
            }
    }
         System.out.println(decodedList);
         return decodedList;
    }

    //Tier 2 (decodeFrom =File: reads data from a file, decodes it, and then writes 
    //the decoded information to a new file (hint: you already have all the tools built to do this, you
    //just need to link them together in the right way!)
    public void decodeFromFile(String fileName, int shift, String newFileName) {

//        fr.readFromFile(fileName);
//        fw.writeContentsToFile(newFileName, fileName, true);
        }
        //FileRead to read
        // call decodeData using the read list
        // FileWrite to write to newfile

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