
package cse.oop2.ch14.example3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;


public class TestDrive {
    
    public static void main(String[] args) throws FileNotFoundException, IOException ,ClassNotFoundException {
        
        String fileName = "scores.ser";
        String fileDir = System.getProperty("user.dir") + File.separator
                + "src/main/java/cse/oop2/ch14/example3".replace("/",File.separator);
        
        System.out.println("fileDir = " + fileDir); //한번 출력해본다. 확인겸 
        
        Person p1 =new Person("홍길동","101");
        Person p2 =new Person("전우치","102");
        Score score1 = new Score(p1,95);
        Score score2 = new Score(p2,92);
        
        //객체 쓰기
        FileOutputStream fos = new FileOutputStream(fileDir + File.separator + fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(score1); //score 객체에 대해서만 writeObject를 하게 되는데 Score 객체가 Person 객체를 갖고 있기 때문에 Person 객체를 같이 파일로 저장하게 된다. 
        oos.writeObject(score2);
        oos.close();
        
        //객체 읽기
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileDir + File.separator + fileName));
        
        List<Score> scores = new LinkedList<>();
        scores.add((Score) ois.readObject()); //readObject로 읽어들인다. 
        scores.add((Score) ois.readObject());
        
        for(Score score : scores){ //앞부분 타입을 var해도 상관이 없다. 
            System.out.println(score.getPerson().getName() + " ("
                  + score.getPerson().getId() + "): " + score.getJava()); //Person에 저장되어 있는 Name과 Id를 가지고 온다. 
        }
        /*
        System.out.format("%s (%d): %d%n", score.getPerson().getName(),score.getPerson().getId(),score.getJava()); 보기 편하다.
        */
        ois.close();
    }
}
