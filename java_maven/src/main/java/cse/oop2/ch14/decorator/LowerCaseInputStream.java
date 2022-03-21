
package cse.oop2.ch14.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class LowerCaseInputStream  extends FilterInputStream{  //바이트 입력 클래스에서 InputStream을 꾸며줄 수 있는 클래스를 만들기 위해서는 기본적으로 FilterInputStream을 상속 받아서 만들어주면 된다.
    
    public LowerCaseInputStream(InputStream in){
        super(in);
    }
    
 
    
    
    // "./src/main/java/cse/oop2/ch14/decorator/test.txt"
    
    @Override
    public int read() throws IOException { //FilterInputStream에 있는 read() 를 override 한다. 
         int c = super.read();
         return(c==-1?c:Character.toLowerCase((char)c));
    } 
    
    public static void main(String[] args){

        try{
        int c;
        InputStream is = new LowerCaseInputStream(new FileInputStream("./src/main/java/cse/oop2/ch14/decorator/test.txt"));
        
         while((c= is.read())>=0){
             System.out.print((char)c);
         }
         }catch(IOException ex){
                 System.out.println("오류 발생 " + ex.getMessage());
                 }
            
        
        }
        
    }








































/*


package cse.oop2.ch14.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class LowerCaseInputStream  extends FilterInputStream{ //바이트 입력 클래스에서 InputStream을 꾸며줄 수 있는 클래스를 만들기 위해서는 기본적으로 FilterInputStream을 상속 받아서 만들어주면 된다.
    
    public LowerCaseInputStream(InputStream in){ //받은 inputStream을 FilterInputStream으로 넘겨주면 된다.
        super(in);
    }
    
    @Override
    public int read() throws IOException { //InputStreamReader에 있는 read() 를 override 한다. 
        int c = super.read(); //InputStream을 이용해서 한 바이트를 읽어 들인다. 물론 타입이 int이기 때문에 int로 받아야 하지만 실제로는 한 바이트만 읽혀지게 된다.
        return(c==-1?c:Character.toLowerCase((char)c)); //c가 -1이면은(오류가 없으면) c를  , 아니면 Charater.toLowerCase((char) c) --> c를 Charater로 바꾸어서(형변환) 소문자로 바꿔준다. Character 클래스에 있는 toLowerCase를 통해서 대문자를 소문자로 바꿔줄려고 한다.(정적메소드이다.) 
    } //Character.toLowerCase 는 클래스 이름으로 쓰여졌기 때문에 정적 메소드라는것을 알 수 있다. , 정적 메소드를 제공하는것을 유틸리티 클래스라고 하는데 , 유틸리티 클래스의 종류와 제공하는 기능을 잘 알고 있으면 프로그램 하는데 편리함
    //c가 -1 일때는 End Of File을 의미한다. 
    
    public static void main(String[] args){
        try{                                      //LowerCaseInputStream 역시 FilterInputStream을 상속 받지만 FilterInputStream이 마찬가지로 InputStream을 상속 받기 때문에 밑에와 같이 InputStream을 데이터 형으로 사용할 수 있다.
            int c;
            InputStream is = new LowerCaseInputStream( //생성된 인스턴스의 데이터 타입은 InputStream이라고 하였다. 바이트 입력 클래스에서 최상위에 있는것이 InputStream이다. InputStream가 LowerCaseInputStream보다 더 큰 클래스이다. 서브 클래스를 사용해서 인스턴스를 만들면은 InputStream이라는 대표 클래스를 사용해서 받을 수 있기 때문에 편리하다.
            new BufferedInputStream(
                    new FileInputStream("./src/main/java/cse/oop2/ch14/decorator/test.txt"))); //"./src/main/java/cse/oop2/ch14/decorator/test.txt" 파일을 읽어와서 하나씩 바이트로 읽고 LowerCase로 바꿔준다.
                                                                                               //InputStream > FilterInputStream > BufferedInputStream = LowerCaseInputStream 상하관계이다.
            while((c = is.read())>=0){ //ImputStream에는 read()라는 것이 정의가 되어 있기 때문에 --> 한 바이트 읽어와서 이것이 >=0 면 --> 문자로 바꿔서 출력을 한다. print라서 1렬로 쭉 나오게 된다. 
                System.out.print((char) c);
               } 
          }catch (IOException ex) { //InputStream , OutputStream에서는 대부분 발생하는것이 IOException이다. 또는 파일 이름이 없어서 NullPointException이 발생하기도 한다.
              System.out.println("오류 발생: " + ex.getMessage()); //InputStream이라는것은 byte 단위로 읽기 때문에 한글이 있는것들이 깨질 수가 있다. 
        }
    }
}
*/