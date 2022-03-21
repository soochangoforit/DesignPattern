/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch05.simpledotcom;

import java.util.ArrayList;

public class DotCom { //원래 게임에서 디버그가 필요해서 다시 수정한 코드들이다
   
  private ArrayList<String> locationCells; //locationCells를 ArrayList으로 바꾼다. locationCells.isEmpty이면 모두 맞춘것을 의미한다. 우리가 맞춰야 할 부분들은 locationCells에 넣는다.
  
  public void setLocationCells(ArrayList<String> loc){
       locationCells = loc; //컴퓨터가 임의로 설정한 부분들을 배열로 받는다.
  }
   
   public String checkYourself(String userInput) {
       
       String result = "miss"; //기본 초기값을 miss으로 한다.
       
       int index = locationCells.indexOf(userInput); //userInput이라는 우리가 예상한 값이 locationCells에 있으면 그 위치의 index를 반환한다. 0보다 큰 정수가 return이 되고 없으면 -1이 return 된다.
       if(index >=0 ){ //userInput을 넣은 값이 locationCells에 있으면 
           locationCells.remove(index); //해당 index에 있는 값을 remove한다.
           if(locationCells.isEmpty()){ //3개를 다 맞추면 empty
               result = "Kill";
           }else { 
               result = "hit";
           }
       } //맞추지 못 하면 기본값인 miss가 return 된다.
       return result; //결과값을 return 한다.
   }
}
        