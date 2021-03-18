import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class Node3 {
    public static byte[] Initialize (String input) throws Exception {
        String keyString = "Bar12345Bar12345"; // 128 bit key
        SecretKey key = new SecretKeySpec(keyString.getBytes(), "AES");
        Cipher cipher;
        cipher = Cipher.getInstance("AES");
        byte[] encryptedString = Node3Encrypt(input, key, cipher);
        return encryptedString;
    }
    public static byte[] Node3Encrypt (String input, SecretKey myKey, Cipher cipher) throws Exception {
        byte[] text = input.getBytes("ISO-8859-1");
        cipher.init(Cipher.ENCRYPT_MODE, myKey);
        byte[] textEncrypted = cipher.doFinal(text);
        return textEncrypted;
    }

    public static SecretKey generateKey (String encryptionType) throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance(encryptionType);
        SecretKey myKey = keyGenerator.generateKey();
        return myKey;
    }

    public static String Node3Decrypt(byte[] input) throws Exception{
        String keyString = "Bar12345Bar12345"; // 128 bit key
        SecretKey key = new SecretKeySpec(keyString.getBytes(), "AES");
        Cipher cipher;
        cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] textDecrypted = cipher.doFinal(input);
        String result = new String (textDecrypted);

        return result;
    }
}