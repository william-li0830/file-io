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
    void testEncodeData() {
        ArrayList<String> data = new ArrayList<>(Arrays.asList("William", "Li"));
        ArrayList<String> encodeList = encrypter.encodeData(data, 2);
        
        assertEquals(encodeList, new ArrayList<>(Arrays.asList("Yknnkco", "Nk")));
    }

    @Test
    void testEncodeToFile() {
        String fileName = "Encrypted.txt";
        ArrayList<String> data = new ArrayList<>(Arrays.asList("William", "Li"));

        encrypter.encodeToFile(data, fileName, 2);
        String expectedString = "YknnkcoNk";
        assertEquals(expectedString, reader.retrieveDataFromFile(fileName));
    }
    
    @Test
    void testRandomizedEncrypter(){
        encrypter.randomizedEncrypter("RandomEncrypterTest.txt");
    }
    
    @Test
    void textLayeredEncryption(){
       String encodedString = encrypter.layeredEncrytion("Hello William");
        String expectedString = "Mhqot#\\lqondr";
        assertEquals(expectedString, encodedString);
    }
}