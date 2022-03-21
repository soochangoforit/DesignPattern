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
public class Dog {
    
    private String name;
    
    public Dog(String name) { //name을 초기화 시켜주기 위해서 , 생성자의 조건 :  class와 이름이 같고 return 타입이 없다 
        this.name = name; // 앞에 있는것은 인스턴스 변수를 의미 뒤에 있는 name은 매개변수를 의미
    }
    
    public String getName() {
        return name; //인스턴스 변수값을 return 하는 값이다.
    }
    
    public void bark(){
        System.out.println(name + "이(가) 왈!하고 짖습니다.");
    }
}
