/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch02.game;


public class Player {
    
    private int number = 0; //초기값 설정 , 찍은 숫자를 저장 할 변수
    
    public void guess(){ //void 는 접근 제어자가 default라서 return 값이 없다.
        number = new java.util.Random().nextInt(10); 
        System.out.printf("찍은 숫자: %d%n",number);
    }
    
    public int getNumber(){
        return number; //number를 getNumber에 다시 넣기 위해서 객체 만들어줌
    }
}
