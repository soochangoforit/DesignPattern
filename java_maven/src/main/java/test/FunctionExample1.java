/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 *
 * @author tncks
 */
public class FunctionExample1 {
    
    private static List<Student> list = Arrays.asList(
			new Student("홍길동" , 90 , 96),
			new Student("신용권", 90 ,96) );


public static void printString(Function<Student,String> fi ){
		
	for(Student student : list ){
		System.out.print( fi.apply(student) + "");
			}
	 System.out.println();
}


public static void printInt(ToIntFunction<Student> fo){
	
     for(Student student : list ){
						System.out.print( fo.applyAsInt(student) + "");
			}
	 System.out.println();
}


public static void main(String[] args){
		 System.out.println("[학생 이름 ]");
		 printString( Student::getName ); // printString의 인자로 구체화된 람다식을 넣는다.
	
		System.out.println("영어 점수 ]");
		 printInt( Student::getEnglishScore);
 }
    
}
