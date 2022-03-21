/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author tncks
 */
public class Student {
    
    	private String name;
	private int englishScore;
	private int mathScore;

	public Student(String name, int englishScore , int mathScore ) {

			this.name = name;
			this.englishScore = englishScore;
			this.mathScore = mathScore;

		}

    public String getName() {
        return name;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }

        
    
    
}
