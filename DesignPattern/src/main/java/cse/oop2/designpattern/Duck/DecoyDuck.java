/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.oop2.designpattern.Duck;

import cse.oop2.designpattern.Duck.QuackBehavior_Interface.MuteQuack;
import cse.oop2.designpattern.Duck.FlyBehavior_Interface.FlyNoWay;

/**
 *
 * @author tncks
 */
public class DecoyDuck extends Duck{

    public DecoyDuck(){ // Duck 추상 클래스의 필드로 선언된 부분을 생성자와 함께 초기화
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }
    
    
    @Override
    public void display() {
            System.out.println("저는 가짜 오리입니다.");
    }
    
}
