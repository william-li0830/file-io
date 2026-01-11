import org.junit.jupiter.api.Test;

/**
 *
 * @author william.li
 */
public class FileDecrypterTest {

    private final FileDecrypter decrypter = new FileDecrypter();

    @Test
    void testDecodeFromString() {
       decrypter.decodeFromString("Yknnkco", 2);
//       assertEquals(true, 123);
    }
    
    @Test
    void testDecodeList(){
        String[] phrase = {"Jgnnq","Yknnkco"};
        decrypter.decodeList(phrase, 2);
    }
    
    @Test
    void testDecodeFromFile(){
     
    }
}