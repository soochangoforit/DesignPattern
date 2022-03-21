
package cse.oop2.ch14.example3;


public class Score implements java.io.Serializable {
    
    private Person person; //person이 직접 만든 class 이기 때문에 Person 클래스가 Serializable 되어 있어야만 Score를 저장할때 Person도 같이 저장한다.
    private int java;

    public Score(Person person, int java) {
        this.person = person;
        this.java = java;
    }

    public Person getPerson() { //Person 객체를 반환 
        return person;
    }

    public int getJava() {
        return java;
    }
    
    
}
