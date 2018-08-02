package linearFramework;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptDecryptStringWithDES {
    private static Cipher ecipher;
    private static Cipher dcipher;
    private static SecretKey key;

    /**
     * method to encrypt given text
     *
     * @param text
     * @return
     */
    public String encryptText(String text) {
        String result = "";
        try {
            // generate secret key using DES algorithm
            key = KeyGenerator.getInstance("DES").generateKey();
            ecipher = Cipher.getInstance("DES");
            // initialize the ciphers with the given key
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            String encrypted = encrypt(text);
            result = encrypted;

        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm:" + e.getMessage());
            return null;
        } catch (NoSuchPaddingException e) {
            System.out.println("No Such Padding:" + e.getMessage());
            return null;
        } catch (InvalidKeyException e) {
            System.out.println("Invalid Key:" + e.getMessage());
        }
        return result;
    }

    /**
     * method to decrypt an encrypted text
     *
     * @param encryptedText
     * @return
     */
    public String decryptText(String encryptedText) {
        String result = "";
        try {
            dcipher = Cipher.getInstance("DES");
            // initialize the ciphers with the given key
            dcipher.init(Cipher.DECRYPT_MODE, key);
            String decrypted = decrypt(encryptedText);
            result = decrypted;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm:" + e.getMessage());
            return null;
        } catch (NoSuchPaddingException e) {
            System.out.println("No Such Padding:" + e.getMessage());
            return null;
        } catch (InvalidKeyException e) {
            System.out.println("Invalid Key:" + e.getMessage());
        }
        return result;
    }

    /**
     * method to encrypt a given string
     *
     * @param str
     * @return
     */
    private static String encrypt(String str) {
        try {
            // encode the string into a sequence of bytes using the named charset
            // storing the result into a new byte array.
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);
            // encode to base64
            enc = BASE64EncoderStream.encode(enc);
            return new String(enc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * method to decrypt an encrypted string
     *
     * @param str
     * @return
     */
    private static String decrypt(String str) {
        try {
            // decode with base64 to get bytes
            byte[] dec = BASE64DecoderStream.decode(str.getBytes());
            byte[] utf8 = dcipher.doFinal(dec);
            // create new string based on the specified charset
            return new String(utf8, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * method is used to unit test the methods in EccryptDecryptStringWithDES class
     * @param args
     */
    /*public static void main(String[] args) {
        EncryptDecryptStringWithDES enc = new EncryptDecryptStringWithDES();
        String dispText = enc.encryptText("pradeep");
        System.out.println("Encrypted Text :" + dispText);
        System.out.println("Decrypted Text: " + enc.decryptText(dispText));
    }*/
}