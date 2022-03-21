/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch08.pet_interface;

import cse.oop2.ch08.animal_list.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalTestDrive {
    
    public static void main(String[] args){
        
        List<Animal> list = new ArrayList<>(); //Animal의 자료형만 받을 수 있는 List list를 만든다.
        Dog a = new Dog();
        Cat c = new Cat();
        //Tiger는 Pet이 아니라서 뺐다.
        
        list.add(a);
        list.add(c);
        
        System.out.println("동물이 " + list.size() + "마리 있습니다.\n");
        for(var animal : list) { //Animal 자료형을 가지고 있는 list를 하나 하나 꺼내어서 animal에 넣는다.
            System.out.println(animal.getClass().getName() + ":");
            animal.makeNoise();
            animal.sleep(); //sleep은 Animal 클래스에 선언됨 .밑에 부분은 interface에 의해 새롭게 추가된 부분이다. 
            if(animal instanceof Dog || animal instanceof Cat){ //for문으로 list에서 가져온 animal이 Dog의 인스터스 , Cat의 인스턴스인 경우에만 if문 실행
                    Pet p = (Pet) animal; //Pet 인터페이스에 정의되어 있는 play()를 사용하기 위해 . 원래 Animal의 Dog , Cat 자료형을 가지고 있던 인스턴스 변수를 Type Casting을 통해서 자료형을 바꾼다.
                    p.play(); //Pet 인터페이스에 정의된 play 사용
                    
                   ((Pet) animal).play(); //이렇게도 사용이 가능하다.
                   
               }
              System.out.println();
     }
   }
}
