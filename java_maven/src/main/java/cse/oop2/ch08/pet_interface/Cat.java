/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch08.pet_interface;

import cse.oop2.ch08.animal_list.*;

public class Cat extends Animal implements Pet{ 
    
    @Override
    public void makeNoise(){
        System.out.println("야옹 야옹");
    }
    
    @Override
    public void play(){
        System.out.println("그루밍을 하면서 잘 놉니다.");
    }
}
