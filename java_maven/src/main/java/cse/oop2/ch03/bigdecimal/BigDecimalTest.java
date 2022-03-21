/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch03.bigdecimal;

import java.math.BigDecimal;

/**
 *
 * @author tncks
 */
public class BigDecimalTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigDecimal n1 = new BigDecimal("12345.12345");
        //BigDecimal n1 = new BigDecimal("13455547");
        BigDecimal n2 = new BigDecimal("123456798123468900");
        System.out.format("n1 = %s, n2 = %s%n",n1,n2); //BigDecimal의 경우 굉장히 큰 숫자를 다룰수 있다. 그러니 format시 %d , %f 가 아니라 toSring 으로 받기 때문에 %s로 받아야한다.
    
        double d1 = 12345.12345;
        double d2 = 12345678901234567890.0;
        System.out.format("d1 = %f,d2 = %f%n",d1,d2); //double 소수점은 %f를 사용한다. format , printf 할때 , float를 사용시 숫자 뒤에 f를 붙여준다.
        
        n1 = new BigDecimal("5.6");
        n2 = new BigDecimal("5.8");
        
        BigDecimal result1 = n1.add(n2);
        System.out.format("n1 = %s, n2 = %s%n, result1 = %s%n",n1,n2,result1); //BigDecimal은 %s로 받는다.
        
        d1 = 5.6;
        d2 = 5.8;
        double result2 = d1 + d2;
        System.out.format("d1 = %s,d2 = %s,result2 = %s%n",n1,n2,result2);
    }
    
}
