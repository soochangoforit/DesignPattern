
package DecoratorPattern;


public class Base implements IBeverage {
    
    @Override
    public int getTotalPrice(){
        return 0; // 아무것도 없는 상테에서는 가격이 산출되지 않도록 하기 위해서
    }
    
    
}
