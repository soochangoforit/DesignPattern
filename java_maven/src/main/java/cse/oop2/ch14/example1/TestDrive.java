
package cse.oop2.ch14.example1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class TestDrive {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Score score1 = new Score("홍길동", 95); //2개의 Score 객체를 만든다. 
        Score score2 = new Score("전우치",92);
        
        FileOutputStream fos = new FileOutputStream("./src/main/java/cse/oop2/ch14/example1/scores.ser"); //scores파일로 저장을 해볼려고 한다. 2개의 score 클래스와 동일한 폴더에 저장을 하려고 한다. , 이러한 경로 설정 방법을 상대 경로라고 한다.
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(score1); //기본적인 객체를 저장하는것은 아무런 문제가 없다. 메소드 실행시 FileNotFoundException, IOException이 빌생 할 수도 있어서 try-catch로 처리해도 되지만 여기서는 간단하게 throw문을 사용해서 메인의 바깥에서 메인을 호출하는 JVM에서 에러가 발생 했을때 처리하도록 하였다. 
        oos.writeObject(score2); //실질적으로 main에서 throw하는것은 바람직하지 않다. JVM에서 Exception이 발생하면 프로그램이 종료가 되기 때문에 바람직하지 않다. 
                                 //Score 객체를 저장하려고 할때 Serializable이 구현이 되지 않았기 때문에  NotSerializableException이 발생
        oos.close();
    }
    
} //NotSerializableException이 발생하는것을 볼 수 있다.
