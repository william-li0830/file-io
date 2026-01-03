
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author willi
 */
public class FileReadTest {

    private static final String FILE_NAME = "FileReadTest.txt";
    private final FileRead fileRead = new FileRead();

    @Test
    void testLineCount() {
        assertEquals(3, fileRead.getLineCount(FILE_NAME));
    }

    @Test
    void testWordCount() {
        assertEquals(13, fileRead.getWordCount(FILE_NAME));
    }

    @Test
    void testCharacterCount() {
        assertEquals(54, fileRead.getCharacterCount(FILE_NAME));
    }

    @Test
    void testFileContains() {
        assertEquals(true, fileRead.fileContains(FILE_NAME, "william li"));
    }

    @Test
    void testFileNotContains() {
        assertEquals(false, fileRead.fileContains(FILE_NAME, "yikihj"));
    }

    @Test
    void testGetWordsWithLengthOfFour() {
        ArrayList<String> words = fileRead.getWordsWithLength(FILE_NAME, 4);
        assertEquals(5, words.size());
        System.out.println("Words " + words);
    }

    @Test
    void testGetWordsWithLengthOfZero() {
        ArrayList<String> words = fileRead.getWordsWithLength(FILE_NAME, 0);
        assertEquals(0, words.size());
        System.out.println("Words " + words);
    }
}
