/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch10.silly;


public class SillyQuestion {
    
    public static void main(String[] args){
        test(); //같은 클래스안에서의 정적 메소드는 바로 사용이 가능하다
        
        SillyQuestion.test(); //클래스 이름을 써서 호출 , 일반적이다.
        
        SillyQuestion q = new SillyQuestion(); //객체를 만든 다음에 일반 메소드처럼 사용한다.
        q.test();
    }
    
    public static void test(){ //정적 메소드이기 때문에 바로 호출 가능
        Duck d = new Duck();
    }
}
    class Duck{
        public Duck(){
            System.out.println("Duck 객체 생성!");
        }
    }

