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
public class Surgeon extends Doctor{ //extends 상속한다. 기억하기 
    
    public Surgeon(boolean worksAtHospital) {
             super(worksAtHospital);    //Doctor(worksAtHosiptal)의미
    }
    
    @Override
    public void treatPatient(){ //override 재정의 했다.
        System.out.println("외과 수술을 합니다.");
    }
    
    public void makeincision(){
        System.out.println("살을 쨉니다.");
    }
}
