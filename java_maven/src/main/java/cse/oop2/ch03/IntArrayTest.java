/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch03;

import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 *
 * @author tncks
 */
public class IntArrayTest {
    
    public static final int MAX_NUMS = 1000; //static final로 사용하면 변수가 아닌 상수처럼 사용, 대문자 사용해서 이름지정 [final 상수 , 고정되어 있는 변수]
    
    public void test(){
        int[] nums; //nums는 배열이다..
        long sum = 0; // long은 큰 정수형식이다.
        
        nums = new int[MAX_NUMS]; //1000개의 배열을 만들어서 nums에 연결 시켜준다.
        for ( int i = 0; i < MAX_NUMS; i++) { //1000번 실행할때 난수를 각각 더해준다.
            nums[i] = (int) (Math.random()*100); //0~99까지의 정수를 nums[i]에 넣는다. , java.util.Random().nextInt(100)으로 이제 바꿔서 사용하는 추세이다.
            sum = sum +nums[i]; //nums[0]~nums[999]까지의 난수를 모두 더한다.
        }
        System.out.println("평균 1: " + (float) sum / MAX_NUMS ); // [sum은 long 타입 , MAX_NUMS는 int 타입] 원래는 정수가 나오지만 소수점 아래도 보기 위해 sum을 float아니 double로 강제적으로 type casting을 한다.
        this.calculateSumUsingWrapper(nums); //nums의 1000개의 배열이 들어간다.
    }
    
    public void calculateSumUsingWrapper(int[] nums) {
        
        OptionalInt sum = java.util.Arrays.stream(nums).reduce((x,y)-> (x + y)); // *중요* [stream은 한개의 integer를 가지고 와서 연산을 할 수 있도록 한다.] [reduce는 2개의 파라미터를 받아서 그것을 하나로 만들어주는 개념 ; 전부다 더해주는것 ] 람다 표현식(이름이 없는 함수를 만드는것) for문 쓰지않고 사용가능하다. , 값이 int일수도 있고 아닐수도 있기때문에 optionalInt를 쓴다.  
        OptionalDouble avg = java.util.Arrays.stream(nums).average(); //*중요* 람다식으로 표현이 가능하지만 워낙 많이 하기 때문에 average라는 메소드가 이미 정의가 되어있다.
        if (sum.isPresent() && avg.isPresent()){ //isPresent : 값이 있는 경우 ture 아닐 경우 false 여부 판단 , 둘다 true 일때 if문 실행
            System.out.printf("합계 = %d, 평균 2: %f%n",sum.getAsInt(),avg.getAsDouble()); //*중요* getAsInt : int로써 값을 가지고 온다. getAsDouble : double로 값을 가져온다.
        } //reduce 의 개념 : 여러 개의 객체들에 대해서 바이너리 연산을 통해서 한개의 값으로 만드는 연산, 감소시켜서 하나로 되게 하는것이다. 
    }
}
