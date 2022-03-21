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
public class TestDrive {
    
    public static void main(String[] args){
    
    
    Doctor doc = new Doctor(true);
        System.out.println(doc); // doc.toString 과 동일한 의미 
        doc.treatPatient();
        System.out.println();
        
    FamilyDoctor familyDoctor = new FamilyDoctor(true,false); //메소드 이지만 생성자라고 생각하면 된다.
        System.out.println(familyDoctor); // doc.toString 과 동일한 의미 , 실제로는 정의하지 않았지만 부모 클래스의 toString을 출력한다.
        familyDoctor.treatPatient();
        familyDoctor.giveAdvice();
        System.out.println();
        
    Surgeon surgeon = new Surgeon(true);
        System.out.println(surgeon); // doc.toString 과 동일한 의미
        surgeon.treatPatient();
        surgeon.makeincision();
            
    }
    
}
