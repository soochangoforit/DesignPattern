/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch08.pet_interface;

import cse.oop2.ch08.animal_list.*;

public class Dog extends Animal implements Pet{ //*중요* , Animal를 부모 클래스로 하고 Pet 인터페이스를 구현함으로써 인터페이스에 저장된 메소드를 override를 해서 사용한다.
    
    @Override
    public void makeNoise(){ //Animal에 있는 메소드를 override하는것이다.
        System.out.println("멍멍");
    }
    
    @Override
    public void play(){ //Pet interface에 있는것을 override한것이다. interface는 형태만 있지 실제로 의미를 담고 있는것은 아니다.
        System.out.println("냄새를 맡으며 뛰어 다닙니다.");
    }
    
}
