/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch02.game;


public class GuessGame {
    
    Player p1; //인스턴스 변수
    Player p2; // Player 객체 3개를 저장하기 위한 인스턴스 변수 3개 
    Player p3;
    
    public void startGame(){
        p1 = new Player();         //Player 객체 3개를 생성하고 각각 
        p2 = new Player();         // Player 인스턴스 변수 세개에 대입
        p3 = new Player();
        
        int guessp1 = 0;          //지역변수 return 한 값을 넣는다.
        int guessp2 = 0;          // Player 객체 3개에서 찍은 숫자를 저장하기 위해
        int guessp3 = 0;          // 변수 3개를 선언
        
        boolean p1isRight = false;   // 찍은 숫자가 맞는지 여부를 저장하기 
        boolean p2isRight = false;   // 위해 변수 3개를 선언
        boolean p3isRight = false;
        
        int targetNumber = (int) (Math.random()*10); // java.util.Random().nextInt(10) 이렇게 하는게 추세이다.
        System.out.println("0 이상 9 이하의 숫자를 맞춰보세요.");
        
        while (true){
            System.out.printf("맞춰야 할 숫자는 %d입니다.%n",targetNumber);
            
            p1.guess();
            p2.guess();
            p3.guess();
            
            guessp1 = p1.getNumber(); //찍은 숫자를 return 한다.
            System.out.printf("1번 선수가 찍은 숫자: %d%n",guessp1);
            guessp2 = p2.getNumber();
            System.out.printf("2번 선수가 찍은 숫자: %d%n",guessp2);
            guessp3 = p3.getNumber();
            System.out.printf("3번 선수가 찍은 숫자: %d%n",guessp3);
            
            if(guessp1 == targetNumber){ //위에서 보다 싶이 원래는 right의 기본값이 false로 설정 되어있다.
                p1isRight = true;
            }
            if (guessp2 == targetNumber){
                p2isRight = true;   
            }
            if (guessp3 == targetNumber){
                p3isRight = true;
            }
            
            if(p1isRight || p2isRight || p3isRight){ //||는 or 의미  3개 중에서 하나라도 true 가 있으면 if문 시작한다.
                System.out.println("맞춘 선수가 있습니다.!");
                System.out.printf("1번 선수 : %b%n", p1isRight); //boolean의 값을 printf로 받을때는 %b를 사용한다.
                System.out.printf("2번 선수 : %b%n", p2isRight);
                System.out.printf("3번 선수 : %b%n", p3isRight);
                System.out.println("게임 끝");
                break; //break는 현재 속해진 메소드를 종료한다.
            }
            else{
                System.out.println("다시 시도해야합니다.\n=======");
            }
            
        }
        
    }
}
