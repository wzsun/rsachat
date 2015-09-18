/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smessage;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author Wesley
 */
public class RSA {
    // n = pq
    // e = public key 
    // public key (n,e)
    // private key = d
    private BigInteger n, d, e;
    private int bitlen = 1024;
    
    public RSA (BigInteger newn, BigInteger newe){
        n = newn;
        e = newe;
    }
    
    public RSA (int bits) {
        bitlen = bits;
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitlen /2, 100, r);
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("3");
        while (m.gcd(e).intValue() > 1){
            e = e.add(new BigInteger("2"));
        }
        d = e.modInverse(m);
    }
    

    public BigInteger getN() {
      return n;
    }

    public BigInteger getE() {
      return e;
    }
    
    public String encrypt(String message){
        return (new BigInteger(message.getBytes())).modPow(e,n).toString();
    }
    
    public String decrypt(String message) {
        return new String((new BigInteger(message)).modPow(d, n).toByteArray());
    }

}
