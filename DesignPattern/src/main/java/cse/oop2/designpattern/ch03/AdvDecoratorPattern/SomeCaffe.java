
package cse.oop2.designpattern.ch03.AdvDecoratorPattern;

import cse.oop2.designpattern.ch03.DecoratorPattern.*;


public class SomeCaffe {
    public static void main(String[] args) {
        HouseBlend hb = new HouseBlend();
        Espresso esp = new Espresso();
        
        System.out.println("HouseBlend 커피는 얼마인가요?");
        System.out.println(String.format("HouseBlend는 %.2f입니다.", hb.cost()));
        
        System.out.println("Espresso 커피는 얼마인가요?");
        System.out.println(String.format("Espresso는  %.2f입니다.", esp.cost()));
        
        System.out.println("House 커피에 우유을 추가해주세요.");
        hb.setMilk(true);
        System.out.println("우유를 추가한 House는 " + hb.cost() + "입니다.");
        
        System.out.println("HOuse 커피에 우유를 더 추가하면 얼마인가요?");
        System.out.println("현재 클래스 구조상 더 이상 추가할 수 없습니다.");
        
        
    }
    
}
