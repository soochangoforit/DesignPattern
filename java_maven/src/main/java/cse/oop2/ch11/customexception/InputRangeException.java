/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch11.customexception;


public class InputRangeException extends Exception{ //Exception을 상속 받는다. 
    
    private int n;
    
    public InputRangeException(int n){ //생성자를 만든다. n 값을 받아서 내부적으로 관리한다. 
        this.n = n;
    }
    
    @Override
    public String getMessage(){
        String message = "입력값 n에 이상이 없습니다.";
        
        if(n<1){
            message = String.format("n 값이 1보다 커야 합니다. (n = %d)", n);
            
        }
        return message;
    }
}
