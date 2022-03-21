
package cse.oop2.ch11.customexception;


public class TestDrive {


    public static void main(String[] args) {
        
        MySum sum = new MySum(); //MySum 인스턴스를 만든다. 
        
        sum.setN(0); //n = 0으로 들어간다. n은 1보다 적기 때문에 InputRangeException을 발생 시킬 것이다. , n = 10을 넣게 되면 10까지의 숫자 모두 더한 55가 정상적으로 출력이 된다.
        int result = -1;
        
        try{
            result = sum.getSum();
        } catch(InputRangeException ex){ //getSum()이 정상적으로 만들지 않은경우 발생한다. 
            System.out.println("예외 발생: " + ex.getMessage()); //InputRangeException 클래스 안에 있는 getMessage()가 호출이 되어 "n값이 1보다 커야 합니다." 출력된다.  
        }
        System.out.printf("n = %d, result = %d%n",sum.getN(),result);
    }
    
}
