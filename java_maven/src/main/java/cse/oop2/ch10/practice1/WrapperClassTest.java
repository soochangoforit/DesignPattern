/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch10.practice1;

/**
 *
 * @author tncks
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
public class WrapperClassTest {
    
    public static void doSomething(List<Integer> numbers){ //numbers는 20개를 가질수 있는 List이다.
        System.out.print("첫 번째 출력: ");
        numbers.forEach(e->System.out.print(e.toString()+" ")); //numbers에 들어간 0~99까지의 난수, 20개가 모두 출력된다. --> Integer형태가 toString()에 의해서 String으로 출력된다.
        
        System.out.print("\n두 번째 출력: "); //위의 코드랑 동일한 내용이다.
        for(int e : numbers){ //numbers 배열에 들어가 있는 숫자를 하나씩 가져와서 모두 다 1렬로 출력한다.
            System.out.print(e + " ");
        }
        
        System.out.print("\n합계1: ");
        Optional<Integer> sum1 = numbers.stream().reduce((x,y) -> x + y); //numbers 에 들어있는 int 값들을 하나씩 다 더해준다.
        if(sum1.isPresent()){ //Optioinal을 사용할때는 이 값이 오류가 있는지 없는지 확인하기 위해 항상 isPresent()로 확인해야 한다.
            System.out.println(sum1.get()); //get()해서 모두 합한 결과를 출력한다.
        }
        
        System.out.print("합계2: "); //Stream<Integer> 자료형
        Integer sum2 = numbers.stream().reduce(0,Integer::sum); //Integer 클래스에 sum이라는 메소드가 내장되어 있다. (2개를 받아서 더한다) 값을 쭉 더해서 출력한다.
        System.out.println(sum2);
        
        System.out.print("합계3: "); //IntStream에 정의됨
        int sum3 = numbers.stream().mapToInt(e->e).sum(); //Integer객체를 숫자로 바꿔서 다 더한다. stream()에 mapToInt()와 sum()이 내장되어 있다.mapToInt는 IntStream으로 바뀐다. IntStream으로 바꾸고 IntStream에 내장된 sum()을 사용한다.
        System.out.println(sum3);                         //IntStream에는 Integer 연산을 위하 average(),count(),max(),min(),sorted(),sum()이 들어있다
                                                          //mapToInt(e->e).sum() == reduce(0,Integer::sum) 같은 의미이다.
        System.out.print("평균: ");
        OptionalDouble avg = numbers.stream().mapToInt(e->e).average(); //IntStream mapToInt에 정의된 average를 사용한다.
        if(avg.isPresent()){ //Optional을 사용하면 isPresent()랑 get()이 내장되어 있다.
            System.out.println(avg.getAsDouble());
        }
    }
    
    public static void doConversion(){
        Integer i1 = new Integer("123"); //사용하지 말라
        Integer i2 = Integer.parseInt("123"); //String --> Integer로 바꾼다.
        String s1 = i1.toString(); //Integer i1을 String으로 바꾼다.
        int number = i2.intValue(); //Integer안에 intValue()는 Int를 반환하게 한다.
        
        System.out.printf("%d %d %s %d %n", i1,i2,s1,number);
        
        try{
            Integer i3 = Integer.parseInt("123.5"); //123.5는 Integer이 아니다.
        } catch(NumberFormatException ex){ //NumberFormatException는 "A" 이렇게 넣었을때도 발생한다. 현재는 123.5가 int가 아니라서 오류가 발생한다.
            System.err.println("예외 발생: " + ex);
        }
    }
    
    public static void main(String[] args){
        List<Integer> numbers = new LinkedList<>(); //Integer만 들어가도록
        
        for(int i=0 ; i <20 ;i++ ){
            int value = (int)(Math.random() * 100); //0~99까지의 숫자가 value안에 int 형으로 들어간다.
            numbers.add(value);        //numbers는 Integer만 받을 수 있지만 컴파일러에서 오토박싱이 적용된다. (boxing conversion이 발생)
        }
        doSomething(numbers);  //doSomething이 static으로 정의가 되어있어서 바로 사용이 가능하다.
        doConversion();
    }
}
