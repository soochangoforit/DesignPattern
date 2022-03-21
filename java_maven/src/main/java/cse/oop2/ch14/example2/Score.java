
package cse.oop2.ch14.example2;


public class Score implements java.io.Serializable { //Serializable를 구현해주기
    
    private  String name;
    private int java;

    public Score(String name, int java) {
        this.name = name;
        this.java = java;
    }

    public String getName() {
        return name;
    }

    public int getJava() {
        return java;
    }
    
    
}
