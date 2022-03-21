/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch07.base;

/**
 *
 * @author tncks
 */
public class Base {
    
    private int number; //하위 클래스에서 부모 클래스의 인스턴스 변수를 바로 사용 할 수 없기 때문에 get - set으로 사용한다.
    
    public Base(){
    this(1);
    }

    public Base(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
    
   
}
