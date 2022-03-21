/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch08.animal_arraylist;

import cse.oop2.ch08.animal_list.Animal;
import cse.oop2.ch08.animal_list.Cat;
import cse.oop2.ch08.animal_list.Dog;
import cse.oop2.ch08.animal_list.Tiger;
import java.util.ArrayList;
import java.util.List;

public class AnimalTestDrive {
    
    public static void main(String[] args) {
        
       List<Animal> list = new ArrayList<>(); //지네릭 사용, List는 Animal만 받을 수 있다. List list를 생성
       Dog a = new Dog();
       Cat c = new Cat();
       Tiger t = new Tiger();
       
       list.add(a); //Animal 자식 클래스에 있는것도 넣을 수 있다.
       list.add(c);
       list.add(t);
       
        System.out.println("동물이 " + list.size() + "마리 있습니다.\n"); //list.size() : 배열이 크기를 가지고 온다.
        for(Animal animal : list) { //Animal만을 받아들일수 있는 list에서 하나 하나 꺼내어서 animal로 저장을 한다. for(var animal : list)로도 사용이 가능하다. animal의 실제 자료형이 결정이 된다.
            System.out.println(animal.getClass().getName()+ ":");
            animal.makeNoise();
            animal.sleep();
            System.out.println();
        }
    }
    
}
