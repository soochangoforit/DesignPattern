/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch01.bottle;

/**
 *
 * @author tncks
 */
public class BeerSong {

    
    public static void main(String[] args) {
       int beerNum = 99;
       String word = "bottles";
       
       while (beerNum > 0) { //1이 되는 순간 word는 bottels -> bottle이 된다.
           
           System.out.println(beerNum +" " + word + " of beer on the wall");
           System.out.println(beerNum + " " + word + " of beer.");
           System.out.println("Take one down.");
           System.out.println("Pass it around");
           beerNum = beerNum - 1;
           
           if(beerNum == 1) {
               word = "bottle";
                  
           }
           
           if ( beerNum > 0) {
               System.out.println(beerNum + " " + word + " of beer on the wall");
           } else {
               System.out.println("No more bottles of beer on the wall");
           }
           
           System.out.println("\n======================");
                   
       }
       
    }
    
}
