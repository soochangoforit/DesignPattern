/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch05.simpledotcom;

/**
 *
 * @author tncks
 */
public class SimpleDotComTestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDotCom_ori dot = new SimpleDotCom_ori();
        
        int[] locations = {2,3,4}; //임의로 설정해둔 위치 2,3,4
        dot.setLocationCells(locations); //2,3,4의 배열을 set으로 이용해서 앞서 선언한 배열 locationCells 에 저장한다.
        
        String userGuess = "2"; //사용자는 유추할 위치를 String 형태로 넣는다.
        String result = dot.checkYourself(userGuess); //checkYourself 메소드의 결과 값을 result 에 넣는다.
        String testResult = "failed"; //testResult의 기본값 failed 으로 설정
        if(result.equals("hit")) {
            testResult = "passed";
        }
        System.out.println(testResult);
    }
    
}
