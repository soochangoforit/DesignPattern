/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch01.phrase;


public class PhraseOMatic {
    
    public static void main(String[] args){
        String[] wordListOne = {"24/7","multi-Tier","30,000 foot","B-to-B","win-win",
            "front-end","web-based","pervasive","smart","six-sigma","criticial-path","dynamic"};
        
        String[] wordListTwo = {"empowered","sticky","value-added","oriented","centric","distributed","clustered",
            "clustered","branded","outside-the-box","positioned","networked","focused"
,"leveraged","targeted","shared","cooperative","accelerated"};    
        
        String[] wordListThree = {"process","tipping-point","solution","architecture","core competency","strategy","minidshare","portal","space","vision","paradigm","mission"};
        
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;
        
        int rand1 = (int) (Math.random()*oneLength); // java.util.Random().nextInt(oneLength);
        int rand2 = (int) (Math.random()*twoLength);
        int rand3 = (int) (Math.random()*threeLength);
        
        String phrase = String.format("%s %s %s",wordListOne[rand1], wordListTwo[rand2], wordListThree[rand3]);
        
        System.out.println("What we need is a "+ phrase);
    

    }
}
