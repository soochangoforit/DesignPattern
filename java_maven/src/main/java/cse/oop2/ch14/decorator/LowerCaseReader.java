
package cse.oop2.ch14.decorator;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class LowerCaseReader extends FilterReader{ //FilterReader를 상속 받는 LowerCaseReader를 만들어야 한다.
    
    public LowerCaseReader(Reader in){ //생성자로써 Reader  매개 변수로 받은 것을 super를 통해 FilterReader로 넘겨준다. --> FilterReader에 있는 생성자를 호출한다. 
        super(in);
    }
    
    @Override
    public int read() throws IOException{ //Reader에 있는 read() 메소드를 Override 해준다.
        int c = super.read();             //한 문자씩 읽는다. 문자는 2바이트씩 읽어들인다. read()의 return 유형은 int이다.
        return(c ==-1?c:Character.toLowerCase((char)c)); //c가 -1이면(오류이면) c를 , 그렇지 않으면 int c 를 (char)로 형변환을 해주고 , Character 클래스에 있는 정적 메소드 toLowerCase()를 이용해서 대문자를 소문자로 바꿔준다.
    }
    
       public static void main(String[] args){
        try{                                      
            
            String fileName = "test.txt";
            
            String fileDir = System.getProperty("user.dir") + File.separator + "src/main/java/cse/oop2/ch14/decorator".replace("/",File.separator);
            
            Reader reader = new LowerCaseReader(new InputStreamReader (new FileInputStream(fileDir + File.separator + fileName) , "UTF-8"));
            
            int c;
            while((c=reader.read())>=0){
                System.out.print((char) c);
            }
              }catch(IOException ex){
                    System.out.println("오류 발생 " + ex.getMessage());
                    }
            
            
            
            
            //인코딩 문제 발생시 이렇게 처리할 수 있다.
            //InputStreamReader(InputStream in, String charsetName) 사용하여 인코딩 지정
            /*
            Reader is = new LowerCaseReader(
                      new InputStreamReader(
                        new FileInputStream("./src/main/java/cse/oop2/ch14/decorator/test.txt"), "UTF-8"));
            */
            
            
            
        
    }
}
//InputStreamReader는 인코딩을 지정할 수 있고 FileReader는 인코딩을 지정할 수 없다.






















/*

package cse.oop2.ch14.decorator;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;


public class LowerCaseReader extends FilterReader{ //FilterReader를 상속 받는 LowerCaseReader를 만들어야 한다.
    
    public LowerCaseReader(Reader in){ //생성자로써 Reader  매개 변수로 받은 것을 super를 통해 FilterReader로 넘겨준다. --> FilterReader에 있는 생성자를 호출한다. 
        super(in);
    }
    
    @Override
    public int read() throws IOException{ //Reader에 있는 read() 메소드를 Override 해준다.
        int c = super.read();             //한 문자씩 읽는다. 문자는 2바이트씩 읽어들인다. read()의 return 유형은 int이다.
        return(c ==-1?c:Character.toLowerCase((char)c)); //c가 -1이면(오류이면) c를 , 그렇지 않으면 int c 를 (char)로 형변환을 해주고 , Character 클래스에 있는 정적 메소드 toLowerCase()를 이용해서 대문자를 소문자로 바꿔준다.
    }
    
       public static void main(String[] args){
        try{                                      
            int c;
            Reader is = new LowerCaseReader( //LowerCaseReader는 FilterReader를 상속 받고 FilterReader는 또 다시 Reader 클래스를 상속 받는다. 그래서 데이터 타입을 Reader로 받는다. 즉) Reader > FilterReader > LowerCaseReader 상하관계이다. 
            new BufferedReader(
                    new FileReader("./src/main/java/cse/oop2/ch14/decorator/test.txt"))); //파일 경로명을 잘 기억해야 한다.
           
            //인코딩 문제 발생시 이렇게 처리할 수 있다.
            //InputStreamReader(InputStream in, String charsetName) 사용하여 인코딩 지정
            /*
            Reader is = new LowerCaseReader(
                      new InputStreamReader(
                        new FileInputStream("./src/main/java/cse/oop2/ch14/decorator/test.txt"), "UTF-8"));
            */
            
            
      /*      
            while((c = is.read())>=0){ //문자 단위로 읽기 때문에 실행을 하면은 한글도 깨지지 않고 잘 출력된다. , 대신 영어 대문자는 소문자로 바뀐다.
                System.out.print((char) c);
               } 
          }catch (IOException ex) { 
              System.out.println("오류 발생: " + ex.getMessage()); 
        }
    }
}
*/









