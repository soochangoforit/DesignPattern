/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch03;

/**
 *
 * @author tncks
 */
public class DogArrayTest {
    
    public void test() {
        Dog[] myDogs = new Dog[3]; //3개의 Dog 객체를 가지는 배열을 정의한다. 
        
        myDogs[0] = new Dog("Fred"); //Dog는 String name을 받고 있다.
        myDogs[1] = new Dog("Marge");
        myDogs[2] = new Dog("Bart");

        System.out.print("마지막 개의 이름: ");
        System.out.println(myDogs[myDogs.length - 1].getName()); //배열 (3 - 1) = (2) index 2 가 나온다. name으로 Bart가 나온다.

       // for(Dog dogs : myDogs){
        // dogs.bark();
       // }
        int x = 0; //이번 while 문은 x가 0부터 시작해서 2까지 배열에 속해 있는 모든것들을 불러온다.
        while (x < myDogs.length) { // *중요 : 람다식으로 표현법 * 또 다른 람다 표현식은 java.util.Arrays.stream(myDogs).forEach(e -> e.bark()); e는 하나씩의 dog객체를 의미한다. e는 정해진것이 아니다 dog이니깐 d해도 상관이 없다. -> : 간접 연산자 , e가 주어졌을때 어떻게 할 것인가?  
            myDogs[x].bark();
            x = x + 1;
        } 
    }
}

//람다 표현식 중요 : java.util.Arrays.stream(myDogs).forEach(e->e.bark());
//for(Dog dogs : myDogs) { 이 방법도 적용이 가능하다 myDogs의 객체 타입 Dog으로 설정하고 dogs는 myDogs에 들어있는 것들을 하나 하나씩 넣어서 bark() 를 실행한다.
// dogs.bark();
//      }
