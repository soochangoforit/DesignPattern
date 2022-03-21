/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch04.encapsulation;

/**
 *
 * @author tncks
 */
public class GoodDogTestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GoodDog one = new GoodDog();
        one.setSize(70);
        
        GoodDog two = new GoodDog();
        two.setSize(8);
        
        GoodDog three = new GoodDog();
        three.setSize(35);
        
        System.out.println("Dog one: " + one.getSize());
        System.out.format("Dog two : %d%n", two.getSize());
        one.bark();
        two.bark();
    }
    
}
