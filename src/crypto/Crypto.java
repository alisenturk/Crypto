package crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {

    private Cipher      encryptCipher;
    private Cipher      dencryptCipher;
    private SecretKey   secretkey;
    public Crypto(String key) {
        try {
            
            secretkey = new SecretKeySpec(key.getBytes(), "AES");
            
            encryptCipher = Cipher.getInstance("AES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretkey);

            dencryptCipher = Cipher.getInstance("AES");
            dencryptCipher.init(Cipher.DECRYPT_MODE, secretkey);
        } catch (Exception e) {
            System.out.println("ERROR..:" + e.getMessage());
        }
    }

    public String encrypt(String str) {
        try {
            byte[] utf8 = str.getBytes("UTF-8");
            byte[] enc = encryptCipher.doFinal(utf8);

            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (Exception e) {
            System.out.println("ERROR..:" + e.getMessage());
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

            byte[] utf8 = dencryptCipher.doFinal(dec);

            return new String(utf8, "UTF-8");
        } catch (Exception e) {
            System.out.println("ERROR..:" + e.getMessage());
        }
        return null;
    }
}
