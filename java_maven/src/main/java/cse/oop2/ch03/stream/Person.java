/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch03.stream;

/**
 *
 * @author tncks
 */
public class Person implements Comparable<Person> { //*implements comparable<Person> , 정렬을 사용하기 위해서 Comparable 인터페이스를 구현해준다. 객체 타입은 Person으로 지정
    
    private String name;
    private int age;
    private Gender gender; //Gender는 데이터 타입

    public Person(String name, int age, Gender gender) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
    
    
    @Override //*중요* 아래부터 3줄
    public int compareTo(Person o) { //Comparable 인터페이스에 정의가 되어있다. sorting에 따라서 정렬을 한다. 
        return getName().compareTo(o.getName()); //앞의 name은 인스턴스 변수를 받는다. 다른 사람의 name을 비교한다. 첫번째 name이 2번째 name보다 작으면 -1 같으면 0 크면 1 ; 이름으로 크다 작다를 어떻게 구분하냐, 사전에 등록된 순서로 판단 소문자 abc순서 
    } // comparable은 오름차순 정렬을 위해서 사용하는것이다., 내림차순도 가능 리턴값 0 ,1 ,-1은 기본정렬 + 또 다른 정렬을 할때 사용된다.
} // 나이를 오름차순으로 적용하기 위해서는 getAge()-o.getAge();
  // 나이를 내림차순으로 적용하기 위해서는 o.getAge()-getAge();
