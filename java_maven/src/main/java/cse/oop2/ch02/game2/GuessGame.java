/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch02.game2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessGame {
    
    private int machineGeneratedNumber;
    private int userGuessNumber = -1;
    public static final int MAX_COUNT = 5;
    
    Scanner in = new Scanner(System.in);
    
    
    ArrayList<Player> players = new ArrayList<>(); // 여러명의 player를 담는 배열을 생성

    private void generateRandomNumber(){
        this.machineGeneratedNumber = (int)(Math.random()*100); //컴퓨터가 임의로 정하는 랜덤의 숫자 new java.util.Random().nextInt(10);
        
    }
    
    
    public void startGame() throws IOException{
        int count = 0;
        boolean matched = false;
        int times = 0;
        
        System.out.println("컴퓨터가 임의로 생성한 0~9까지 한 자리 숫자를 맞추는 게임입니다.");
        System.out.println("5번 안에 맞추면 당신이 이기고 그렇지 않으면 컴퓨터가 이깁니다.");
        System.out.println("이제 시작하겠습니다.");
        System.out.println("");
        
      
        System.out.print("\n플레이를 할 사용자의 이름을 '/' 을 이용해서 입력하세요 : ");
        String n = in.nextLine();
        String[] names = n.split("/"); // 플레이어 이름들을 names 배열에 저장
        
        // 향상된 for문을 사용하면 times를 여러번 안써도 괜찮다.
        for(String s : names)
        {
            System.out.println(s + "님 차례입니다.");
            System.out.print("0 ~ 9까지의 숫자를 입력하세요 : ");
            String num = in.nextLine();
            int guessNumber = Integer.parseInt(num);
            
            players.add(new Player(s,guessNumber)); //players 배열에 각 플레어들의 상태를 저장
        }
      
        
        
        
        // 입력한 이름 수만큼 객체를 생성하여 배열에 저장을 한다.
         
        //생성한 객체 수만큼 for문을 사용하여 , 사용자의 입력을 받도록 하고 , 틀렸는지 맞는지 확인한다.
         
        // 다음 플레이어 시작할때는 다음 인덱스의 배열 객체를 가지고 와서 시작한다.
        
        

        
        }
    
    }
