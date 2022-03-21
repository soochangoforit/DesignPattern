/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch05.game;

import cse.oop2.ch05.simpledotcom.DotCom;
import java.util.ArrayList;

/**
 *
 * @author tncks
 */
public class DotComGame {
    
    
    
    public static void main(String[] args)  { //예외 던짐 , 예외 던져야 하는거 던지지 않아도 되는거 확인해보기
        
        int numOfGuesses = 0; //추측하는 횟수
        
        GameHelper helper = new GameHelper(); //중요***********************
        DotCom theDotCom = new DotCom();
        
        int randomNum = (int)(Math.random()*5); // 임의의 숫자 선정 java.util.Random().nextInt(5);
        System.out.format("(randomNumber = %d)%n",randomNum); //임의의 숫자 출력.
        
        String stringNum1 = Integer.toString(randomNum); //int를 String 형태로 바꾸었다.
        String stringNum2= Integer.toString(randomNum+1);
        String stringNum3 = Integer.toString(randomNum+2);
        //0~7사이에 숫자만 받을 수 있도록 배열 생성
        ArrayList<String> locations = new ArrayList<>(); //힙에 new 저장해야한다.
        
        locations.add(stringNum1);
        locations.add(stringNum2);
        locations.add(stringNum3);
        
        theDotCom.setLocationCells(locations); // SimpleDotCom의 데이터 타입을 갖는 객체 theDotCom을 이용해서 메소드 이용 , locations의 배열을 locationCells 배열에 저장한다. 임의의 연속된 숫자 배열
        
        boolean isAlive = true;
        while(isAlive == true) {
            String guess = helper.getUserInput("enter a number"); //GameHelper의 객체 helper에서 메소드 사용 , return값으로 내가 guess한 값들이 String 형태로 반환된다.
            String result = theDotCom.checkYourself(guess);//맞추거에 따라서 miss,hit.kill이 result값으로 출력된다. checkYourself에서 내가 넣은 guess값이 String -> Int로 변환되고 그 값에 따라서 String 형태로 miss,hit,kill이 반환된다.
            System.out.println(result); //결과 확인을 위해 새로 추가한 부분
            numOfGuesses++; //guess한 횟수를 점차 증가시킨다. , kill하지 못 하면 kill할때까지 while문이 계속 돌아간다.
            
            //isAlive가 false가 될때까지 추측 횟수를 저장하고 무한으로 돌린다.
            if (result.equals("Kill")){
                isAlive = false;
                System.out.println("You took " + numOfGuesses + "guesses");
            }
        }
         
        
  }
}

