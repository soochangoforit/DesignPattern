
package cse.oop2.ch14.example1;


public class Score { //Serializable이 구현이 되어 있지 않아서 오류가 발생한다. 
    
    private String name; //인스턴스 변수
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
