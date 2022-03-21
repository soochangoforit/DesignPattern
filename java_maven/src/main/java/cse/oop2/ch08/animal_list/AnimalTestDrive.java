/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch08.animal_list;

/**
 *
 * @author tncks
 */
public class AnimalTestDrive {
    
    public static void main(String[] args){
        
        MyAnimalList list = new MyAnimalList(); //list는 MyAnimalList 클래스의 인스턴스 변수이다.
        Dog a = new Dog();
        Cat c = new Cat();
        Tiger t = new Tiger();
        
        list.add(a);  //MyAnimalList에 정의 되어 있는 Animal[] 배열에 더해진다.
        list.add(c);
        list.add(t);
        
        System.out.println("동물이" + list.getNextIndex() + "마리 있습니다.\n"); //list.getNextIndex() --> 현재 배열이 차있는 개수를 의미한다.
        for(int i = 0 ; i < list.getNextIndex(); i++){
            System.out.println(list.get(i).getClass().getName() + ":"); //getClass().getName()--> 패키지 이름과 현재 클래스의 이름을 출력한다.
            list.get(i).makeNoise(); //각각 객체들이 가지고 있는 메소드를 호출한다.
            list.get(i).sleep();
            System.out.println();
        }
    }
    
}
