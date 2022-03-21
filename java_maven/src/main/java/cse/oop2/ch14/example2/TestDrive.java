
package cse.oop2.ch14.example2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;


public class TestDrive {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        String fileName = "scores.ser"; //scores파일을 저장하기 위해서 
       
        String fileDir = System.getProperty("user.dir") + File.separator + "src/main/java/cse/oop2/ch14/example2".replace("/",File.separator);
        
        //경로 지정 앞에서 example1에서는 상대 경로를 통해서 지정을 해줬다. 
        //getProperty를 사용하여 현재 working 디렉토리를 지정한 다음 File에 있는 정적 메소드 separator를 사용해서 separator는 "/"를 의미한다. "/"를 통해서 경로명을 지정한 다음 replace를 호출해서 "/"를 File.separator로 변경하게 되면은 현재 시스템에서 사용하고 있는 경로명으로 바꿀수가 있다.
        //getProperty("user.dir")를 하게 되면은 현재 working 디렉토리 즉) 자바 버추얼 머신이 실행 되는 폴더를 의미한다. 
        //위와 같은 경로 지정 방법은 새로운 파일을 연결하기 직전까지 과정을 보여주는것이다.
        
        Score score1 = new Score("홍길동",95); //score 인스턴스를 만든다. 
        Score score2 = new Score("전우치",92);
        
        
        //객체 쓰기 - Output , FileOutputStream()는 인자로 파일을 만들고 저장해야 할 경로가 들어가야 한다.
        FileOutputStream fos = new FileOutputStream(fileDir + File.separator + fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos); 

        oos.writeObject(score1);
        oos.writeObject(score2);
        oos.close();
        
        
        
        //객체 읽기 Input -> 제대로 저장이 되었는지 확인을 해본다. , FileInputStream()에는 저장된 파일의 객체 상태를 가져오는것이기 때문에 , 저장된 파일의 이름만 필요하다. 경로는 따로 필요없다.
        FileInputStream fis = new FileInputStream(fileDir + File.separator + fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        
        List<Score> scores = new LinkedList<>();
        scores.add( (Score)ois.readObject());
        scores.add( (Score)ois.readObject());
        
        
        for (var score : scores) { //scores에 있는 하나 하나의 item을 받는 score 이름으로 했는데 타입이 var로 되어 있다. 지역 변수 선언 시 초기화된 코드 사용하면 자료형을 지정 안해도 된다. 
            System.out.println(score.getName() + ":" + score.getJava()); //읽어 들어온 객체를 하나씩 출력한다. 제대로 복원이 된것을 알수 있다. 
        }
        
        /*
        socre.forEach(e->{System.out.println(e.getName() + ":" + e.getJava()); }); 람다표현식으로도 사용이 가능하다. 
        */
        ois.close(); //ObjectInputStream에 대한 자원을 반환한다. 
         
    }
    
}



/*
package cse.oop2.ch14.example2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;


public class TestDrive {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        String fileName = "scores.ser"; //scores파일을 저장하기 위해서 
        
        String fileDir = System.getProperty("user.dir") + File.separator + //File separator ("/" on UNIX)
                "src/main/java/cse/oop2/ch14/example2".replace("/",File.separator); //경로 지정 앞에서 example1에서는 상대 경로를 통해서 지정을 해줬다. 
        //getProperty를 사용하여 현재 working 디렉토리를 지정한 다음 File에 있는 정적 메소드 separator를 사용해서 separator는 "/"를 의미한다. "/"를 통해서 경로명을 지정한 다음 replace를 호출해서 "/"를 File.separator로 변경하게 되면은 현재 시스템에서 사용하고 있는 경로명으로 바꿀수가 있다.
        //getProperty("user.dir")를 하게 되면은 현재 working 디렉토리 즉) 자바 버추얼 머신이 실행 되는 폴더를 의미한다. 
        //위와 같은 경로 지정 방법은 새로운 파일을 연결하기 직전까지 과정을 보여주는것이다.
        
        Score score1 = new Score("홍길동",95); //score 인스턴스를 만든다. 
        Score score2 = new Score("전우치",92);
        
        
        //객체 쓰기 - Output , FileOutputStream()는 인자로 파일을 만들고 저장해야 할 경로가 들어가야 한다.
        FileOutputStream fos = new FileOutputStream(fileDir + File.separator + fileName); //시스템에 적합한 경로명을 만들어준다. ,fileDir는 File.separator로 구분 해놓은 상태이고 fileName은 저장할 이름이기 때문에 그 2개의 경로 사이에 File.separator를 사용해준다.
        ObjectOutputStream oos = new ObjectOutputStream(fos); //생성된 FileOutputStream객체를 인자로 넘겨주게 된다. 
        //인스턴스를 writeObject를 통해 저장해준다. 
        oos.writeObject(score1); //writeObject를 사용해서 score1,score2를 저장해주고 close해준다. 
        oos.writeObject(score2); //score 1,2 순서를 잘 기억해야 한다. 
        oos.close();             //해당 되는 파일로 객체의 상태가 잘 저장이 된다. 
        
        
        //객체 읽기 Input -> 제대로 저장이 되었는지 확인을 해본다. , FileInputStream()에는 저장된 파일의 객체 상태를 가져오는것이기 때문에 , 저장된 파일의 이름만 필요하다. 경로는 따로 필요없다.
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileDir + File.separator + fileName)); //앞서 사용했던 Output을 Input으로 사용하면 된다. 
       
        List<Score> scores = new LinkedList<>(); //Score를 저장하는 List를 만든다. LinkedList사용 
        scores.add((Score) ois.readObject()); //ObjectInputStream를 통해서 readObject를 하게 된다. readObject()의 반환형은 Object이다.  읽혀지는 객체를 Object 타입이기 때문에 Score 객체로 type casting을 하게 된다. 이것을 List에 넣는다. 
        scores.add((Score) ois.readObject()); //readObject한 객체를 각각 List에 넣어준다. 
        
        for (var score : scores) { //scores에 있는 하나 하나의 item을 받는 score 이름으로 했는데 타입이 var로 되어 있다. 지역 변수 선언 시 초기화된 코드 사용하면 자료형을 지정 안해도 된다. 
            System.out.println(score.getName() + ":" + score.getJava()); //읽어 들어온 객체를 하나씩 출력한다. 제대로 복원이 된것을 알수 있다. 
        }
        
        /*
        socre.forEach(e->{System.out.println(e.getName() + ":" + e.getJava()); }); 람다표현식으로도 사용이 가능하다. 
        */

        /*ois.close(); //ObjectInputStream에 대한 자원을 반환한다. 
         
    }
    
}
*/