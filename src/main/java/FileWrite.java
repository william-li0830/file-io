
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FileWrite {

    public static final String ALL_WORDS = "AllWords.txt";

    /**
     * Write data to fileName file either overriding or appending
     *
     * @param fileName The name of the file to write to
     * @param data The data to be written
     * @param appendData True = append, False = overwrite
     */
    public void writeContentsToFile(String fileName, String data, boolean appendData) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, appendData));

            writer.println(data);

            writer.close();

        } catch (IOException e) {
            System.out.println("" + e);
        }
    }

    /**
     * Write each string in list to file, each token on a new line
     *
     * @param fileName File name
     * @param contents Array list contents
     * @param appendData False = override data, True = append data
     */
    public void writeContentsToFile(String fileName, ArrayList<String> contents, boolean appendData) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, appendData));

            for (String data : contents) {
                writer.println(data);
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("" + e);
        }
    }

    /**
     * Writes the numbers 1 to 100 to the specified file
     *
     * @param fileName
     * @param appendData
     */
    public void writeNumbers(String fileName, boolean appendData) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, appendData));

            int num = 1; // variable to hold current number to print

            // Print all complete rows to file
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) // Loop through content inside a row
                {
                    writer.print(num + "\t"); // Print each number with an indent in between
                    num++;
                }
                writer.println(); // Create next line
            }

            writer.close(); // Close writer to end session

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    /**
     * Writes the numbers 1 to 100 separated by your custom delimiter
     *
     * @param fileName
     * @param appendData
     * @param delimiter
     */
    public void writeNumbersCustom(String fileName, boolean appendData, String delimiter) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, appendData));

            int num = 1; // variable to hold current number to print

            // Print all complete rows to file
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    writer.print(num + "" + delimiter); // Print each number with custom delimiter in between
                    num++;
                }
                writer.println(); // Create next line
            }

            writer.close(); // Close writer to end session

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Writes the requested range of numbers to a file w custom organization
     *
     * @param fileName Name of file to be written to
     * @param maxNum Highest number to count to
     * @param numsPerRow Max number of entries to appear on each line of the
     * file
     * @param appendData True adds to end of file; false overwrites file
     */
    public void writeNumbersAdvanced(String fileName, int maxNum, int numsPerRow, boolean appendData) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, appendData));

            int numRows = maxNum / numsPerRow; // Determine number of rows fitting custom values needed
            int extraNums = maxNum % numsPerRow; // Determine any leftover from above division for final print step
            int num = 1; // Set up variable to track number printing

            String placeholder = "            ";// Whitespace used to organize output alignment; make bigger if numbers expect to get really big

            // Print all complete rows to file
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numsPerRow; j++) {
                    String output = "" + num; // Cast num to a string
                    writer.print(output += placeholder.substring(0, placeholder.length() - output.length())); // Fit num into the placeholder content to ensure alignment
                    num++;
                }
                writer.println();
            }
            // Finally, print final (shorter) row, if there is one
            for (int k = 0; k < extraNums; k++) {
                String output = "" + num; // Cast num to a string
                writer.print(output += placeholder.substring(0, placeholder.length() - output.length())); // Fit num into the placeholder content to ensure alignment
                num++;
            }

            writer.close(); // Close writer to end session

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Accept 2 files and merge their contents into a new file
     *
     * @param fileOneName
     * @param fileTwoName
     * @param mergedFileName
     */
    public void mergeFiles(String fileOneName, String fileTwoName, String mergedFileName) {
        // Create file reader
        FileRead fr = new FileRead();

        // Snag data from both files
        ArrayList<String> fileOneData = fr.retrieveDataListFromFile(fileOneName);
        ArrayList<String> fileTwoData = fr.retrieveDataListFromFile(fileTwoName);

        // Merge files into one
        fileOneData.addAll(fileTwoData);

        // Write combined data to file
        FileWrite fw = new FileWrite();
        fw.writeContentsToFile(mergedFileName, fileOneData, false);
    }

    // Create a method that can join 3 different file together
    public void mergeFiles(String fileOneName, String fileTwoName, String fileThreeName, String mergedFileName) {
        FileRead fr = new FileRead();

        ArrayList<String> mergedData = new ArrayList<>();

        ArrayList<String> fileOneData = fr.retrieveDataListFromFile(fileOneName);
        ArrayList<String> fileTwoData = fr.retrieveDataListFromFile(fileTwoName);
        ArrayList<String> fileThreeData = fr.retrieveDataListFromFile(fileThreeName);

        mergedData.addAll(fileOneData);
        mergedData.addAll(fileTwoData);
        mergedData.addAll(fileThreeData);

        FileWrite fw = new FileWrite();
        fw.writeContentsToFile(mergedFileName, mergedData, true);
    }

    // Create a method that creates a new file with the contents of the ‘AllWords.txt’ file sorted by word length rather than alphabetically
    public void sortAllWordsByLength(String newFileName) {
        FileRead fileRead = new FileRead();
        ArrayList<String> wordList = fileRead.retrieveDataListFromFile(ALL_WORDS);

        // Tell the comparator to sort by string length
        wordList.sort(Comparator.comparing(String::length));

        FileWrite fw = new FileWrite();
        fw.writeContentsToFile(newFileName, wordList, false);
    }

    // Create a method that writes all sent data (either a String or a List) to a file with a common format decided by you
    // My custom method takes in a list of words. It sorts them alphabetically and 
    // writes to a file with index in front of each word.
    // Example:
    // ["william", "li", "hello"]
    // 1. hello
    // 2. li
    // 3. william
    public void writeCustomData(String fileName, ArrayList<String> words) {
        Collections.sort(words);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, false));
            for (int i = 0; i < words.size(); i++) {
                writer.print((i + 1) + ". ");
                writer.println(words.get(i));
            }

            writer.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}