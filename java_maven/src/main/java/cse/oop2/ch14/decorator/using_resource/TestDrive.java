
package cse.oop2.ch14.decorator.using_resource;

import cse.oop2.ch14.decorator.LowerCaseReader; // 기존의LowerCaseReader는 그대로 사용 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TestDrive {

    public void go() {
        System.out.printf("%s.go() called...\n", getClass().getName()); //클래스를 로딩한다음.클래스 이름을 출력한다.
      
        InputStream in = getClass().getResourceAsStream("./test2.txt");
        //src랑 같은 위치에 있는 resource 파일에서 test2.txt파일을 읽어온다. Stream으로 읽는다 나중에 인코딩을 지정해줘야 한다.
        try{
            
            int c;
            Reader reader = new LowerCaseReader(new InputStreamReader( in,"UTF-8"));
            
            while((c = reader.read())>=0){
                System.out.print((char) c);
            }
        }catch(IOException ex){
            System.out.println("오류 발생" + ex.getMessage());
        }
        
        
                
                
    }

    public static void main(String[] args) {
        new TestDrive().go(); //간단하게 사용할때는 이렇게 해도 괜찮다. 
    }
}

















/*

package cse.oop2.ch14.decorator.using_resource;

import cse.oop2.ch14.decorator.LowerCaseReader; // 기존의LowerCaseReader는 그대로 사용 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TestDrive {

    public void go() {
        System.out.printf("%s.go() called...\n", getClass().getSimpleName()); //클래스를 로딩한다음.클래스 이름을 출력한다.
        InputStream is = getClass().getResourceAsStream("/test2.txt"); //test2를 읽어 들이기 위해 getClass().getResourceAsStream()를 하면 InputStream 반환된다. "/" 를 반드시 앞에 붙여줘여지 찾을 수 있다. 잘 기억하기 ...getResourceAsStream()를 통해 Stream으로 바꿔줘야만 InputStream에서 Stream으로 읽을 수 있다. 
        int c; //파일을 읽을때는 getResourceAsStream()을 쓰면 충분하다.  getResourceAsStream()는 반환형이 InputStream이다.

        try (
                Reader reader = new LowerCaseReader( //reader 객체를 생성한다. LowerCaseReader는 Reader를 상속 받기 때문에 대표 타입 Reader 사용한다. 변수명 reader 
                        new BufferedReader(
                                new InputStreamReader(is, "UTF-8")))) { //test2.txt를 Stream으로 읽어서 InputStream 객체로 받아들이기 때문에 여기서 InputStreamReader를 사용하였다. InputStreamReader는 인코딩이 가능하다.  FileReader는 인코딩이 불가능 하다. 인코딩을 위한 인자를 받을 때는 InputStream 데이터 타입으로 받는다. 비록 한글을 Stream 바이트 형태로 읽었지만, 인코딩을 지정해줌으로써 결과 창에는 한글이 깨지지 않고 잘 보이고 있다.
            while ((c = reader.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println("오류 발생: " + ex.getMessage());

        }
    }

    public static void main(String[] args) {
        new TestDrive().go(); //간단하게 사용할때는 이렇게 해도 괜찮다. 
    }
}
*/