
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author willi
 */
public class FileEncrypterTest {

    private final FileEncrypter encrypter = new FileEncrypter();

    @Test
    void testEncrypt() {
        encrypter.encodeString("William", 2);
    }
    
    @Test
    void testWrapValue() {
        assertEquals(32, encrypter.wrapValue(127, 32, 126));
        assertEquals(33, encrypter.wrapValue(128, 32, 126));
        assertEquals(126, encrypter.wrapValue(31, 32, 126));
        assertEquals(125, encrypter.wrapValue(30, 32, 126));
    }
}
