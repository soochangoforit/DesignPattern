
package PrototypePattern;

public class Test {

    
    public static void main(String[] args) throws CloneNotSupportedException {
        
        Circle circle1 = new Circle(1,1,3);
        Circle circle2 = circle1.copy();
        
        // 추가적으로 circle1과 circle2는 서로 다른 주소값을 가지고 있다.
        // 대신 clone에 의해 같은 필드값을 가지고 있다.
        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
    }
    
}
