import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author william.li
 */
public class FileDecrypterTest {

    private final FileDecrypter decrypter = new FileDecrypter();
    private final FileRead reader = new FileRead();

    void cleanup(String fileName) {
        File f = new File(fileName);
        if (f.exists()) {
            f.delete();
        }
    }

    //All assertEquals()lines(FileDecrypterTest and FileEncrypterTest)are written with some help
    
    @Test
    void testDecodeFromString() {
        assertEquals("William", decrypter.decodeString("Yknnkco", 2));
    }

    @Test
    void testDecodeData() {
        ArrayList<String> data = new ArrayList<>(Arrays.asList("Yknnkco", "Nk"));
        ArrayList<String> decodeList = decrypter.decodeData(data, 2);
        assertEquals(decodeList, new ArrayList<>(Arrays.asList("William", "Li")));
    }

    @Test
    void testDecodeFromFile() {
        String DECODED_FILENAME = "Decrypted.txt";
        String ENCODED_FILENAME = "Encrypted.txt";

        cleanup(DECODED_FILENAME);

        decrypter.decodeFromFile(ENCODED_FILENAME, DECODED_FILENAME, 2);

        // compare decrypted data to expected data
        String decodedString = reader.retrieveDataFromFile(DECODED_FILENAME);
        String expectedString = "WilliamLi";
        
        assertEquals(expectedString, decodedString);
    }
    
    @Test
    void testLayeredDecryption(){
        String decodedString = decrypter.layeredDecrytion("Mhqot#\\lqondr");
        String expectedString = "Hello William";
        
        assertEquals(expectedString, decodedString);
    }
}