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
public class GoodDog {
    
    private int size;//private 으로 만듬 , int size 먼저 생성후 set - get 생성

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    void bark(){ //private size는 한 class 안에서만 볼 수 있다. 따라서 다른 클래스에서 사용할경우 public 으로 지정해서 작성해야한다.
        if(size > 60) {
            System.out.println("Woof! Woof!");
        } else if (size > 14) {
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }
    }
}
