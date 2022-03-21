/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch08.animal_list;

/**
 *
 * @author tncks
 */
public class MyAnimalList {
    
    private Animal[] animals = new Animal[5]; //5개의 Animal 인스턴스를 가질 수 있는 배열을 만든다.
    private int nextIndex = 0;
    
    public void add(Animal a){
        if(nextIndex < animals.length){ //5개 안까지 , 0,1,2,3,4개까지 허용 
            animals[nextIndex] = a; //5개를 가질 수 있는 animals[]에 0번째부터 넣는다 , 5개 까지
            System.out.println("Animal added at " + nextIndex);
            nextIndex++; //총 5개를 넣는다.
        }
    }
    
    public Animal get(int i){ //i번째 값을 가지고 온다.
        Animal a = null;
        if(i >= 0 && i < nextIndex){ //현재 nextIndex는 5이다.
            a = animals[i];
        }
        return a; //i번째에 있는 객체를 리턴한다.
    }
    
    public int getNextIndex(){
        return nextIndex; 
    }
}
