/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch02.dog;


public class DogTestDrive {

    public static void main(String[] args) {
        // TODO code application logic here
        Dog d1 = new Dog(30, "알래스카 말리뮤트" , "보리" );
        d1.bark();
        
        Dog d2 = new Dog(); //기본 생성자에 해당하는것들이 들어간다.
        d2.bark();
        
        Dog d3 = new Dog();
        d3.name = "코코";
        d3.size = 40;
        d3.bark();
    }
    
}
