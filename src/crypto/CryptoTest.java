/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

/**
 *
 * @author asenturk
 */
public class CryptoTest {
    public static void main(String[] args) {
        try {
                         
            String mykey ="9181233368741232";
           
            Crypto crypto = new Crypto(mykey);
            String original = "123";
            System.out.println("Orginal   : " + original);
            String encrypted = crypto.encrypt(original);
            System.out.println("Encrypted   : " + encrypted);
            String decrypted = crypto.decrypt(encrypted);
            System.out.println("Decrypted   : " + decrypted);
         
             
             
        } catch (Exception e) {
        }
 
 
    }
}
