
package cse.oop2.ch02.dog;


public class Dog {
    //인스턴스 변수
    int size;
    String breed;
    String name;
    
    public Dog(){ // 기본 생성자 default 아무런 매개변수가 정해지지 않은것
        this(30, "레브라도 리트리버" , "새론" ); // size , breed , name 순으로 적어준다
    }
    //값을 초기화 시켜줘야 한다

    public Dog(int size, String breed, String name) {
        this.size = size;
        this.breed = breed;
        this.name = name;
    }
    
    void bark(){
        System.out.println(name+ "가/이 짖습니다.");
    }
    
    
}
