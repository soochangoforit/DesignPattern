
package DecoratorPattern;


public class Milk extends AbstAdding{
    
    public Milk(IBeverage meterial){
        super(meterial);
    }
    
    public int getTotalPrice(){
        return super.getTotalPrice() + 50;
    }
    
    
    
    
    
}
