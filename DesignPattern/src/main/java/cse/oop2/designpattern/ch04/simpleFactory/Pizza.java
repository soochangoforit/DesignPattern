
package cse.oop2.designpattern.ch04.simpleFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    
    protected List<String> toppings = new ArrayList<>();
    protected String name;
    protected String dough;
    protected String sauce;
    
    public void prepare(){
        System.out.println("Preparing" + name);
    }
    
    public void bake(){
        System.out.println("Baking" + name);
    }
    
    public void cut(){
        System.out.println("Cutting" + name);
    }
    
    public void box(){
        System.out.println("Boxing" + name);
    }
    
    @Override
    public String toString(){
        StringBuilder display = new StringBuilder();
        
        display.append("--" + name + "---\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        for(int i =0; i<toppings.size(); i++){
            display.append(toppings.get(i) + "\n");
        }
        
        return display.toString();
    }
    
}
