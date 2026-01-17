
/**
 *
 * @author willi
 * This is a helper class for Encrypt and Decrypt class to use
 */
public class Codec {

    public static int MIN_CHAR_INT = 32;
    public static int MAX_CHAR_INT = 126;
    public static int CHAR_RANGE = 126 - 32 + 1;

    public static int characterCast(char letter) {
        return (int) letter;
    }

    public static char convertBackToChar(int number) {
        return (char) number;
    }
    
    public static int wrapChar(int value) {
        return wrapValue(value, MIN_CHAR_INT, MAX_CHAR_INT);
    }

    // Example:
    // wrapValue(13, 2, 5)
    //      range = 5 - 2 + 1 = 4
    //      shiftedValue = 13 - 2 = 11
    //      wrapped = 11 % 4 = 3
    //      final = 3 + 2 = 5
    public static int wrapValue(int value, int min, int max) {
        // gets how many values is in between min and max
        int range = max - min + 1;
        // shifts the value so min becomes 0
        int shiftedValue = value - min;
        // gets the remainder using modulo
        int wrapped = shiftedValue % range;
        // shifts back to original range
        return wrapped + min;
    }
}
