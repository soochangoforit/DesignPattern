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
public class Doctor {

    boolean worksAtHospital;

    public Doctor(boolean worksAtHospital) { //*중요* Doctor에 대한 생성자 생성 , 매개변수
        this.worksAtHospital = worksAtHospital; //this 있으므로 인스턴스 변수의 worksAtHospital이다.
    }

    public void treatPatient() {
        System.out.println("진료를 합니다.");
    }

    
    @Override
    public String toString() {
        String result = null;

        if(worksAtHospital) {
            result = getClass().getName() + ": 병원에서 일하는 의사입니다."; // getSimpleName() : 패키지 이름을 제외한 클래스 이름을 반환
        } else {
            result = getClass().getSimpleName() + ": 집에서 일하는 의사입니다."; //getClass().getName() : Doctor 반환 , 패키지 이름을 포함하는 클래스 이름을 반환
        }

        return result;
    }
}
