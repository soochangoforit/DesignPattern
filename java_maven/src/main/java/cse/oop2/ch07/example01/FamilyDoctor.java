/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch07.example01;

/**
 *
 * @author tncks
 */
public class FamilyDoctor extends Doctor{
    
    boolean makeHouseCalls;
    
    public FamilyDoctor(boolean makeHouseCalls, boolean worksAtHospital){ //Doctor를 상속하기 때문에 worksAtHospital를 매개변수로 사용 가능하다.
              super(worksAtHospital);     //worksAtHospital 이라는 것이 이미 부모 클래스에서 선언이 되었기 때문에 super으로만 받아준다. this.worksAtHospital = worksAtHospital; 이부분을 나타내고자 햇다.  Doctor(worksAtHospital)과 동일한 의미
              this.makeHouseCalls = makeHouseCalls; //makeHouseCalls 매개 변수로 받은것을 초기화 시켜준다.
    
    }
    public void giveAdvice(){
        System.out.println("집에서 필요한 조언을 합니다.");
    }
    
}
