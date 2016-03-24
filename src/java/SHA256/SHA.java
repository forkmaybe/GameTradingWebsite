/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SHA256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author d00133633
 */
public class SHA {
    
    /**
     * SHA-256 is used to encrypt the users password when logging in, changing password and registering
     * the string is converted into bytes and then into hex
     * @param password is passed in from the dao methods to be encrypted 
     * @return string of hex values of password unless there is an exception then return null
     *                       
     */
    public String encrypt(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            //convert the byte to hex format
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("no such algorithm ");
            return null;
        }
    }
}
