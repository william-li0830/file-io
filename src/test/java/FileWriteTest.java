
import java.io.File;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author willi
 */
public class FileWriteTest {

    private final FileWrite fileWrite = new FileWrite();
    private final FileRead fileRead = new FileRead();

    void cleanup(String fileName) {
        File f = new File(fileName);
        if (f.exists()) {
            f.delete();
        }
    }

    @Test
    void testMergeFiles() {
        String MERGED_FILENAME = "MergedFile.txt";
        cleanup(MERGED_FILENAME);

        fileWrite.mergeFiles("FileWriteTest1.txt", "FileWriteTest2.txt", "FileWriteTest3.txt", MERGED_FILENAME);
        String data = fileRead.retrieveDataFromFile(MERGED_FILENAME);
        assertEquals(true, data.contains("1"));
        assertEquals(true, data.contains("2"));
        assertEquals(true, data.contains("3"));
    }

    @Test
    void testSortAllWords() {
        String NEW_FILENAME = "SortedAllWords.txt";
        cleanup(NEW_FILENAME);

        fileWrite.sortAllWordsByLength(NEW_FILENAME);

        ArrayList<String> sortedWordList = fileRead.retrieveDataListFromFile(NEW_FILENAME);
        String firstWord = sortedWordList.get(0);
        String lastWord = sortedWordList.get(sortedWordList.size() - 1);

        assertEquals(false, firstWord.length() > lastWord.length());
    }

    @Test
    void testWriteCustomData() {
        String NEW_FILENAME = "CustomFileWrite.txt";
        cleanup(NEW_FILENAME);

        fileWrite.writeCustomData(NEW_FILENAME, new String[]{"li", "william", "hello"});
        fileRead.readFromFile(NEW_FILENAME);
    }
}
