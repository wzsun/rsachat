/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smessage;



/**
 *
 * @author Wesley
 */
public class Smessage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        RSA rsa = new RSA(1024);
        
        String text = "hello my baby, hello my jolly";
        String encrypted = rsa.encrypt(text);
        String decrypted = rsa.decrypt(encrypted);
        System.out.println(rsa.getN());
      
        
        
    }
    
}
