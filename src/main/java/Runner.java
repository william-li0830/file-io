
import java.util.ArrayList;

public class Runner {
    
    public static final boolean BRUTE_FORCE_TEST = false;

    public static void main(String[] args) {
        FileRead reader = new FileRead();
        FileWrite writer = new FileWrite();
        FileDecrypter decrypt = new FileDecrypter();
        FileEncrypter encrypt = new FileEncrypter();

        if (BRUTE_FORCE_TEST) {
            encrypt.randomizedEncrypter("BruteForceTest.txt");
            decrypt.bruteForceDecryption("BruteForceTest.txt_Encrypted.txt");
        }
    }
}
