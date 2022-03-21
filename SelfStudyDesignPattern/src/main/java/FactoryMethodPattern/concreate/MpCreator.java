package FactoryMethodPattern.concreate;

import FactoryMethodPattern.framework.Item;
import FactoryMethodPattern.framework.ItemCreator;
import java.util.Date;


public class MpCreator extends ItemCreator{

    @Override
    protected void requestItemsInfo() {
           System.out.println("데이터베이스에서 마력 회복 물략의 정보를 가져온다.");
    }

    @Override
    protected void createItemLog() {
        System.out.println("마력 회복 물략을 새로 생성 했습니다. " + new Date());
    }

    @Override
    protected Item createItem() {
        return new MpPotion();
    }
    
}
