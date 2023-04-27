package application.cafe94final;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class encrypts the passwords.
 *
 * @author James Morgan
 * version 1
 */

public class Encryptor {

    /**
     * Encrypts the password input
     *
     * @param input The password in text field.
     * @throws NoSuchAlgorithmException
     */

    public String encryptString(String input) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDigest = md.digest(input.getBytes());

        BigInteger bigInt = new BigInteger(1, messageDigest);

        return bigInt.toString(16);
    }
}
