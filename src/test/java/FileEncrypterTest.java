import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author willi
 */
public class FileEncrypterTest {

    private final FileEncrypter encrypter = new FileEncrypter();
    private final FileRead reader = new FileRead();

    @Test
    void testEncrypt() {
        encrypter.encodeString("William", 2);
    }
    
    @Test
    void testWrapValue() {
        assertEquals(32, encrypter.wrapValue(127, 32, 126));
    }

    @Test
    void testEncodeData() {
        ArrayList<String> data = new ArrayList<>(Arrays.asList("William", "Li"));
        ArrayList<String> encodeList = encrypter.encodeData(data, 2);
        
        assertEquals(encodeList, new ArrayList<>(Arrays.asList("Yknnkco", "Nk")));
    }

    @Test
    void testEncodeToFile() {
        String fileName = "EncodeFile.txt";
        ArrayList<String> data = new ArrayList<>(Arrays.asList("William", "Li"));

        encrypter.encodeToFile(data, fileName, 2);
        String expectedString = "YknnkcoNk";
        assertEquals(expectedString, reader.retrieveDataFromFile(fileName));
    }
    
    @Test
    void testRandomizedEncrypter(){
        
    }
}