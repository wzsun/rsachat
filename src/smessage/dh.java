package smessage;

import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wesley
 */
public class dh {
    BigInteger p;
   BigInteger g;
    public dh(BigInteger p,BigInteger g){
        this.p = p;
        this.g = g;
    }
    public BigInteger alicesend(int a){
        return this.g.pow(a).mod(p);
    }
    
    public BigInteger bobsend(int b){
         return this.g.pow(b).mod(p);
    }
    
    public BigInteger alicecompute(BigInteger bobsent, int a){
        return (bobsent.pow(a)).mod(p);
    }
    
    public BigInteger bobcompute(BigInteger alicesent, int b){
        return (alicesent.pow(b)).mod(p);
    }
}
