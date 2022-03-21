
package FactoryMethodPattern.concreate;

import FactoryMethodPattern.framework.Item;
import FactoryMethodPattern.framework.ItemCreator;


public class Test {
    public static void main(String[] args) {
        // DataType를 interface화
        ItemCreator creator;
        Item item;

        creator = new HpCreator();
        item = creator.create();
        item.use();
        
        creator = new MpCreator();
        item = creator.create();
        item.use();
        
    }
    
}
