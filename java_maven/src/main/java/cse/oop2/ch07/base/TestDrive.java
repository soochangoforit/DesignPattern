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
public class TestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Derived d1 = new Derived(); //Derived()는 상위 클래스의 Base()생성자를 호출한다.
        System.out.println("1: number = " + d1.getNumber()); // Base의 기본 생성자 1을 출력한다.
        
        Derived d2 = new Derived();
        d2.setNumber(10);
        System.out.println("2: number = " + d2.getNumber()); // 10을 출력한다.
    }
    
}
