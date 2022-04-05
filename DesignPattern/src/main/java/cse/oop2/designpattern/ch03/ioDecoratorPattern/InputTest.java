package cse.oop2.designpattern.ch03.ioDecoratorPattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class InputTest {
    public static void main(String[] args) throws IOException {
        
        System.out.println("File.getPath(): " + new java.io.File(".").getPath());
        System.out.println("File.getAbsolutePath(): " + new java.io.File(".").getAbsolutePath());
        System.out.println("File.getCanonicalPath(): " + new java.io.File(".").getCanonicalPath());
        
        System.out.printf("Working Directory = %s\n" , System.getProperty("user.dir"));
        System.out.println("-------------------");
        
        
        try{
            InputStream in = new LowerCaseInputStream(new BufferedInputStream (new FileInputStream("./src/main/resources/test.txt")));
            
            int c;
            while((c=in.read()) >= 0){
                System.out.print((char) c);
            }
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    
}
