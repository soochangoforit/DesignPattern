package PrototypePattern;

// Cloneable를 implements 했다는 말은 clone을 사용할 수 있다는 의미
public class Shape implements Cloneable{
    
    // Object Class에 clone()이라는 메소드가 있다.
    // 해당 Method는 Cloneable interface를 implements를 해줘야지 가능하다.
    
    private String id; //각각의 shape들이 가지는 고유 id

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    
    
}
