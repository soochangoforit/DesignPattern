/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch03.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 *
 * @author tncks
 */
public class StreamTestDrive {
    
    public static List<Person> persons = new LinkedList<>(); //persons 라는 list는 Person 이라는 객체 타입을 가지는데 이 타입은 Person 클래스랑 같다. list 배열을 관리하는 기본적인 자료구조 ,배열과 같은거다 , LinkedList는 객체타입을 Person해도 되고 뒤에는 같으면 생략 가능하다.
            //persons 라는 list를 만들었다.
    
    public static void main(String[] args) {
        
        initialize();
        
        //남자는 몇명??
        long maleCount = persons.stream().filter(e-> e.getGender() == Gender.MALE).count(); //여기서 persons의 배열을 Person이라는 객체 타입을 가지고 있기 때문에 Person 클래스에 있는 메소드를 사용 할 수 있다. persons의 List 배열을 stream으로 바꾸기 filter 여러개의 배열 객체가 있을때 조건을 만족하는 객체에게 적용하는것 의미, e.getGender() 메소드를 사용해서 gender만 return을 한다. 그 return 값들 중에서 Gerder가 MALE인 경우만 걸러낸다. 만족하는것은 놔두고 나머지는 없앤다. 개수를 샌다. long으로 return  
        System.out.printf(">>> 남자는 %d명입니다.%n", maleCount);
        
        //여자의 평균 나이는?
        OptionalDouble femaleAverageAge = persons.stream().filter(e-> e.getGender() == Gender.FEMALE).mapToInt(Person::getAge).average() ; //getGender() 메소드를 사용해서 Gender가 FEMALE인 경우를 추출하고 ,  map 이라는것은 filter하고 남은 여성 객체에다가 map은 1대1로 붙이는 사상함수, return한 person 객체에서 나이만 뽑아내기 위해 getAge() 메소드를 사용해서 age만 추출한다. 그리고 average()를 통해서 평균값을 구한다.         
        if(femaleAverageAge.isPresent()) { //계산이 잘 되었는지 판단 isPresent()를 통해서 
            System.out.printf(">>> 여자의 평균 나이는 %.2f입니다.%n", femaleAverageAge.getAsDouble()); //여자들의 평균나이 femaleAverageAge를 getAsDouble()로 받아들려 double형으로 나타낸다. 
        } //OptionalDouble 혹은 OptionalInt를 사용하고 출력할때는 .getAsDouble() 혹은 .getAsInt()로 받아내야 한다.
        
        
        System.out.println(">>> 20~25살인 여자의 이름을 정렬해서 출력");
        Stream<Person> sp = persons.stream().filter(e-> e.getGender() == Gender.FEMALE).filter(e-> e.getAge() >= 20 && e.getAge() <= 25).sorted();
        sp.forEach(e-> System.out.printf("%s%n",e.getName())); 
        //출력된 배열을 sp의 변수에 넣고 하나 하나씩 출력할때 getName()을 이용해서 이름만 추출할려고 한다. %n은 \n과 같은 의미. 

        //persons를 stream으로 만든다. Gender가 FEMALE 인것을 뽑아낸다. 20~25만족시키는 결과값 출력 filter 2번 적용(조건 and와 같은 의미), sorted 정렬한다 의미
        // class의 경우 implements Comparable<Person>하고 comparteTo를 하면 바로 sorted를 사용 할 수 있다. 
        
    }
    
    public static void initialize(){
        Person[] data = { //Person 클래스를 가져와서 배열을 만들고 data에 넣는다,지금까지는 Person[] data = new Person[5]해서 data[0] = new Person("Linda",21,Gender.FEMALE) 이런식으로 해도 되지만 중괄호{}안에 이렇게 넣어줘도 괜찮다. 대신 한줄 안에 작성을 해야하므로 마지막에 ; 들어가지 않는다.
            //이렇게 하면 따로 배열의 크기를 지정할 필요가 없다. , 일렬로 나열하는 것이지만 보기 쉽게 enter로 행구분을 해놓았다.
            new Person("Linda",21,Gender.FEMALE),
            new Person("Oliver",25,Gender.MALE),
            new Person("Alice",27,Gender.FEMALE),
            new Person("Noah",19,Gender.MALE),
            new Person("Abby",23,Gender.FEMALE),
            new Person("Daisy",25,Gender.FEMALE),
            new Person("Samuel",31,Gender.MALE),
            new Person("Crystal",31,Gender.FEMALE),
            new Person("Tadeo",33,Gender.MALE)
        };
            
        for(Person p : data) { //*중요* for each 문 인덱스 없이 사용한다. Person에 해당하는 하나 하나의 값을 대입. Person이라는 객체 타입을 가지는 배열 data를 p에 하나 하나씩 담는다.
            persons.add(p); //*중요* Persons 라는 객체 타입을 하고 있는 data를 p라는 변수로 담고 , persons 리스트에 하나씩 add한다.
                               // persons.addAll(Arrays.asList(data)); 와 동일하다.
        } //persons.addAll(Arrays.asList(data)); 
    }
    
}
