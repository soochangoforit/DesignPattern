/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch06;

import java.util.ArrayList;


public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>(); //객체 타입이 DotCom만 올 수 있다. 즉 DotCom클래스를 포함한다. , dotComsList에는 3개의 객체가 들어가고 각각의 객체는 1개씩 3*1의 배열을 갖는다.
    private int numOfGuesses = 0; //몇번 guess 하는지 카운트 하는 변수
    
    private void setUpGame(){ //각각의 3개의 객체에 대해서 숫자를 setUp한다. 예를 들어 e0,e1,e2
        DotCom one = new DotCom();
        one.setName("Pets.com"); //각각의 객체에 대한 이름을 설정한다.
        
        DotCom two = new DotCom();
        one.setName("eToys.com");
        
        DotCom three = new DotCom();
        one.setName("Go2.com");
        
        dotComsList.add(one); //dotComsList는 DotCom 데이터 타입을 가지는 ArrayList이다. , dotComsList에 one이라는 객체를 넣는다.
        dotComsList.add(two);
        dotComsList.add(three);
        
        System.out.println("Your goal is to sink three dot coms");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");
        
        for(DotCom dotComToSet : dotComsList){ //DotCom 데이터 타입을 가지고 있는 dotComsList에서 객체를 한개씩 가지고 와서 dotComToSet에 넣는다.
            ArrayList<String> newLocation = helper.placeDotCom(3); //placeDotCom(3) : 한개의 coords의 크기를 3으로 지정한다. , 컴퓨터가 지정한 [b0,c0,d0] 이런 형태의 배열이 newLocation에 넣는다. 
            dotComToSet.setLocationCells(newLocation);//dotComToSet에 public으로 선언된 setLocationCells()를 통해 컴퓨터가 임의로 지정한 [b0,c0,d0]를 newLocation에 넣는다. dotComsList에는 현재 3개의 객체가 저장되고 있고 for문을 통해 각각의 객체에 대해서 컴퓨터가 만든 [b0,c0,d0]이러한 배열이 들어간다.
        } 
         //DotCom <- one <- dotComToSet (dotComToSet에는 one이라는 형태를 가진 DotCom 객체가 3개가 들어가 있다. ,one , two, three 차례로 들어간다.
        // dotComsList.forEach(e->{ArrayList<String> newLocation = helper.placeDotCom(3); e.setLocationCells(newLocation);});
        // 더 간단한 표현 : dotComsList.forEach(e->e.setLocationCells(helper.placeDotCom(3))); dotComsList에 들어있는 3개의 객체에 setLocationCells을 통해 [b0,c0,d0]한것들이 저장이 된다. 
    }
    
    private void startPlaying() { //dotComsList에 있는 3개의 dotCom 객체가 제거 되어야만 끝남
        while(!dotComsList.isEmpty()){ //Empty이 되었으면 빠져나온다 . 그전까지는 계속 돌린다. 비워지면 dotComsList.isEmpty()이 true가 되면서 while문을 빠져나온다.
            String userGuess = helper.getUserInput("Enter a guess"); //유효 값 "[a-g][0-6]" , Enter a guess : 가 나오고 사용자의 입력을 기다린다.
            checkUserGuess(userGuess); //DotCom에서 public으로 설정된 checkUserGuess()를 통해서 miss, hit ,kill인지 판단한다.
        }
        finishGame(); //게임을 끝낸다.
    }
    
    private void checkUserGuess(String userGuess) { //사용자가 넣는 값은 String 형태이다. 
        numOfGuesses++; //사용자가 guess한 횟수를 하나씩 더한다.
        String result = "miss"; //기본적인값 설정
        
        for(DotCom dotComToTest : dotComsList){ //dotComsList에 있는 3개의 DotCom 객체를 불러서  dotComToTest에 넣는다. 
            result = dotComToTest.checkYourself(userGuess); // 각각의 객체에 대해 public 으로 선언된 checkYourself를 한다. ,result 형태를 가지고 온다.
            if(result.equals("hit")) {
            break;
        }
            if(result.equals("Kill")){
                dotComsList.remove(dotComToTest); //한 객체에 대해서 다 맞추었으면 그 객체도 list에서 제거해야 한다. 3개가 다 remove 되면 finishgame 한다.
                break;
            }
        }
        System.out.println(result); //결과값이 miss이면 한번이라도 hit 할때까지 계속 사용자가 값을 넣는다. 왜냐하면 while(!dotComsList.isEmpty())가 비워질때까지 실행이 되므로.  끝나더라도 while(!dotComsList.isEmpty())에서 3개의 객체에 대해 모두 맞출때까지 계속돌린다.
    }
    
    private void finishGame(){
        System.out.println("All Dot Coms are dead! Your stock is now worthless");
        if(numOfGuesses <= 18) { //18번 안에 맞추면 잘 맞춘거라고 설정
            System.out.println("It only took you " + numOfGuesses + "guesses");
            System.out.println("You got out before your options sank");
        } else { //그렇지 않으면 정중률이 낮다라고 판단
            System.out.println("Took you long enough." + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }
    
    public static void main(String[] args){
        DotComBust game = new DotComBust();
        game.setUpGame(); //컴퓨터가 [e0,e1,e2] 이런것들을 만든다. 
        game.startPlaying(); //게임을 시작한다. 
    }
    
    
}
