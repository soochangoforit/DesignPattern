/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.oop2.ch02.movie;

class Movie{
    
    String title; //인스턴스 변수
    String genre;
    int rating;
    
    void playit(){
        System.out.printf("%s(장르 :%s,%d등급)" + "영화를 상영합니다.\n",title,genre,rating);
    }
}

/**
 *
 * @author tncks
 */
public class MovieTestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Movie one = new Movie(); // 초기값을 객체를 생성해서 따로 만들어준다.
        one.title = "Gone with the Stock";
        one.genre = "Tragic";
        one.rating = -2;
        one.playit();
        
        Movie two = new Movie();
        two.title = "Lost in Cubicle Space";
        two.genre = "Comedy";
        two.rating = 5;
        two.playit();
        
        Movie three = new Movie();
        three.title = "Byte Club";
        three.genre = "Tragic but ultimately uplifting";
        three.rating = 127;
    }
    
}
