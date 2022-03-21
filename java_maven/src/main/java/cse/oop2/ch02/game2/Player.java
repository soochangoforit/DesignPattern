
package cse.oop2.ch02.game2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Player {
    
    private String name;
    private int num;
   

    public Player(){} //기본 생성자 생성
    
    
    public Player(String name, int num) {
        this.name = name;
        this.num = num;
      
    }
    
   
    
    
    public void getUserInput() { //사용자가 제대로 형식에 맞게 입력했는지 확인하는 메소드
        
        String inputLine = null; //사용자가 guess하는것을 String 으로 받는다.
        
        System.out.print("0~9까지 숫자를 추측해서 입력해 주세요: "); //커서 바로 뒤에 위치 print
        
        boolean rightNumberFormat = false;
        //하나의 숫자만을 입력할때까지 무한 반복한다 . do - while을 통해서
        do{
            try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in)); 
            inputLine = is.readLine();  
            }catch (IOException e){
              System.out.println("잘못된 형식으로 입력하였습니다.");
            }
            
            if(inputLine.matches("[0-9]")) { //equals 동일한지 여부 검토 matches 규칙이 맞는지 검사 ,입력의 유효성 확인 0~99는 "[1-9]?[0-9]" 
                this.num = Integer.parseInt(inputLine); 
                rightNumberFormat = true; //형식에 맞게 하나의 숫자만 입력을 하면 true를 return 하고 while문을 종료시킨다.
            } else {
                System.out.println("0~9까지의 숫자만 입력해야 합니다! 다시 입력해 주세요 :");
            }
        }
        while (!rightNumberFormat); //초기에 rightNumberFormat은 false이고 true가 들어오면 !true = false가 되기 때문에 밖으로 나온다.
    }

   
    
    
    
    
    
} // end of class
