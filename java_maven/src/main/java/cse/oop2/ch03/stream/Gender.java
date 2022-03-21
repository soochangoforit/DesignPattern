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

    
    public enum Gender{ // enum은 class가 아니다. *중요 enum* ,Gender라는 객체 타입을 가지는 FEMALE,MALE 인스턴스 객체가 생성된다.
        FEMALE("female"), //FEMALE , MALE 전부 대문자로 적는다.  그것들이 가질 String 문자열을 뒤에 적는다.
        MALE("male");
        
        private String info;
        
        private Gender(String info) { //Gender라는 객체에 생성자를 만들었다. Gender에 속한 객체는 이러한 생성자를 갖게 된다.
            this.info = info;
        }
        
        public String toString(){
            return info;
        }
    }
    

