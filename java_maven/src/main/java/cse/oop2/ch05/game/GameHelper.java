/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch05.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author tncks
 */
public class GameHelper {
    
    public String getUserInput(String prompt) {
        
        System.out.println(prompt + ": ");
        String inputLine = null; // 초기값 설정
        
        try{
         BufferedReader is = new BufferedReader(new InputStreamReader (System.in));
         inputLine = is.readLine();
         
         if(inputLine.length() == 0) { //아무것도 안누르고 enter눌렀을때
             return "-1"; //에러가 있음을 간접적으로 표현
            }
        } catch(IOException e) {
            System.out.println("IOException: " + e);
            System.out.println("아무것도 입력하지 않았습니다.");
        }
          if(inputLine != null && inputLine.matches("[0-9]")){ //inputLine에는 0~9 사이의 숫자가 입력 되어야 한다.
                 return inputLine;
          } else {
            return "-1"; //에러가 있음을 나타낸다것을 간접적으로 표현
            }
    }
}
