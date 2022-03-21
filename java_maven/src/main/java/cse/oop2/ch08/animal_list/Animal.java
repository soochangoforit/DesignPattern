/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch08.animal_list;


public abstract class Animal{ //추상 클래스
    
    public abstract void makeNoise(); //메소드에 abstract 있으므로 반드시 클래스도 abstract로 지정해야 한다.
    
    public void sleep(){
        System.out.println("잠을 자려고합니다.");
    }
} 
