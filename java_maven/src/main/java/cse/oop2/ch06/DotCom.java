
package cse.oop2.ch06;

import java.util.ArrayList;


public class DotCom {
    
  private ArrayList<String> locationCells; //locationCells를 ArrayList으로 설정한다.. locationCells.isEmpty이면 모두 맞춘것을 의미한다.
  private String name;
  
  public void setLocationCells(ArrayList<String> loc){ //locationsCells를 초기화 하는 작업이고 동일한 자료형을 가지고 있다.
       locationCells = loc; //컴퓨터가 만든 [e0,e1,e3]를 locationCells ArrayList에 넣는다. locationCells ArrayList에는 총 3개의 객체에 대한 3개의 정답 배열이 들어가있다.
  }
   
   public String checkYourself(String userInput) {
       
       String result = "miss";
       int index = locationCells.indexOf(userInput); //locationCells에는 3개 각각의 객체들이 만든 [e0,e1,e2]이러한것들의 배열이 3개가 있다.. ,userInput이라는 값이 locationCells에 있으면 0보다 큰 정수가 return이 되고 없으면 -1이 return 된다.
       if(index >=0 ){ //userInput을 넣은 값이 locationCells에 있으면 
           locationCells.remove(index); //locationCells에 내가 입력한 영문자+숫자가 들어가있으면 해당 index에 있는 값을 remove한다.
           if(locationCells.isEmpty()){ //3개를 다 맞추면 empty 그리고 result는 Kill을 반환한다.
               result = "Kill";
           }else { 
               result = "hit";
           }
       }
       return result; //결과값을 return 한다.
   }
   
   public void setName(String string){ //DotCom 객체의 이름을 지정한다.
       name = string;
   }
}
