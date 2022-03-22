
package BuilderPattern;

public class Test {

    
    public static void main(String[] args) {
      
        Computer computer = ComputerBuilder
                .start()
                .setCpu("i7")
                .setRam("8g")
                .build();
        
        System.out.println(computer.toString());
        
    }
    
}
