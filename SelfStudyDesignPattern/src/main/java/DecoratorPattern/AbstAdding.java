
package DecoratorPattern;


public class AbstAdding implements IBeverage{
    
    private IBeverage base;
    
    public AbstAdding(IBeverage base){
        this.base = base;
    }
    
    public int getTotalPrice(){
        return base.getTotalPrice();
    }
    
    protected IBeverage getBase(){
        return base;
    }
    
}
