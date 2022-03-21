/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch10.practice;

/**
 *
 * @author tncks
 */
public class Duck {
    private int size;
    private static int duckCount = 0; //특별히 초기화를 안하면 0으로 초기화 된다.
    private int nth; //몇번째 duck인지 기억 , 따로 만들지 않으면 모든 생성된 Duck()클래스 안에선는 같은 duckCount를 같게 된다.
    
    private static Duck[] ducks; //정적 변수 Duck 배열 생성
    
    public Duck(){ //매개 변수가 없는 경우
        this(10); //밑에 Duck 생성자의 int size에 10이 들어간다. 
        
    }
    
    public Duck(int size){
        this.size = size;
        nth = duckCount++; //생성된 duck 인스턴스가 몇번째 Duck 인스턴스인지 기억한다.
    }
    
    @Override
    public String toString(){ //Duck 인스턴스 변수의 상태 정보를 정리.
        StringBuilder sb = new StringBuilder();
        sb.append("나는 ");
        sb.append(nth);
        sb.append("번째 오리이고, ");
        sb.append("크기는 ").append(size).append("입니다."); //append해서 원하는 메시지를 출력하도록 한다.
        //return 타입이 StringBuilder이다. -->sb안에 순차적으로 들어가서 문자열을 만든다.(Builder 패턴)
        
        return sb.toString();
    }
    
    public static void initialize(){ //정적 메소드 
        ducks = new Duck[10];
        
        ducks[0] = new Duck(); //매개 변수가 없는 생성자는 매개 변수 size 한개 있는 생성자를 호출하여 코드 중복을 방지한다. 처음으로 만든 duck()는 size가 10으로 정의됨
        
        for(int i = 1; i<ducks.length;i++){
            int size = (int)(Math.random()*20) + 10; //(0~19)~ + 10 --> (10 ~ 29)의 난수 생성
            ducks[i] = new Duck(size); //Duck 배열 중에서 나머지 9개의 인스턴스 변수를 만든다. 1번째 ~ 9번째
        }   
    }
    
    public static void main(String[] args){
        initialize(); //initialize()는 static 메소드 이기 때문에 바로 사용이 가능하다(같은 클래스 안에서 )Duck 배열 10개를 만든다.
        
        for(Duck d : ducks){ //duck의 toString이 호출이 된다.
            System.out.println(d);
        }
    }
}
