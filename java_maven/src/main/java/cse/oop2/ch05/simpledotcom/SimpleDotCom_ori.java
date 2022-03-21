/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch05.simpledotcom;

public class SimpleDotCom_ori {
    

   int[] locationCells; //인스턴스 변수 , 컴퓨터 임의로 설정하는 연속되는 숫자 3자리 (0~9까지)
   int numOfHits = 0; // 인스턴스 변수, 추측하는 횟수 저장.
   public int guess = 0; //사람이 예상하는 숫자
   
   public void setLocationCells(int[] locations) {
       locationCells = locations;
   }
   
   public String checkYourself(String stringGuess) {
       //내가 guess 한 값들을 배열로 만든다 , 내가 guess 하는것들 String으로 받는다.
       
        guess = Integer.parseInt(stringGuess); //정수로 변환한다. String을 int로 변환  
        String result = "miss"; //기본값 miss로 설정 틀렸을때 가정
       
       for(int cell : locationCells) { // int cell : (in) locationCells 에서 : 는 in을 의미한다. locationCells에 있는 cell에 대해서 의미
           
           if(guess == cell) { //locationCells에 있는 3개의 cell이 내가 예상한 값과 같을때
               result = "hit";
               numOfHits++; // 증가가 필요하다.
               break;
           } // 추측한 값이랑 연속으로 설정된 값이랑 다르면 result는 miss를 반환
       }  
       if(numOfHits == locationCells.length) { //현재 locationCells.length은 3개이다.
             result = "Kill"; // 다 맞으면 kill 반환
    }  
       System.out.println(result);
       return result;
 }
}
