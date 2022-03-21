/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch11.customexception;

/**
 *
 * @author tncks
 */
public class MySum {
    
    private int n = 0; //n값을 저장하기 위해 private으로 저장을 한다. 

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public int getSum() throws InputRangeException{ //오류가 생기면 예외를 throw 한다. n<1 경우 , InputRangeException는 계산할 수 없는 범위에 있는  n 값에 대하여 InputRangeException 발생 
        if(n<1){
            throw new InputRangeException(n); //n값이 얼마인지 InputRangeException에 넘겨주고 인스턴스를 만든 다음에 throw를 해준다 , getSum()을 사용하는 메소드 내에서 예외처리가 발생하게 된다.
        }
        return (n*(n+1)/2); //예외가 없는 경우 수식을 계산해서 전달
    }
    
}
