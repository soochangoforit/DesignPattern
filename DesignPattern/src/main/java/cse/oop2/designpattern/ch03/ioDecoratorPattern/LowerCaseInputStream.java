package cse.oop2.designpattern.ch03.ioDecoratorPattern;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class LowerCaseInputStream extends FilterInputStream {

    // InputStream을 생성자에서 받고 , FilterInputStream에 잇는 InputStream을 초기화 시켜준다.
    public LowerCaseInputStream(InputStream in) {
        super(in);
    }
    
    public int read() throws IOException{
        int c= super.read();
        return ( c == -1 ? c : Character.toLowerCase((char) c));
    }
    
    public int read(byte[] b ,int offset , int len) throws IOException {
        int result = super.read(b, offset , len);
        
        for(int i = offset ; i < offset + result ; i++){
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
        
    }
    
    
    
    
    
    
    
    
}
