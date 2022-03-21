
package SingletonPattern;


public class SystemSpeaker {
    
    // 생성자가 애초에 private이기 때문에 -> 아무리 변수를 public이라 해도 접근할 수가 없다. 
    // public instance를 gettter를 통해 가져오고 싶어도 , 생성자에 의한 인스턴스가 만들어지지 않았기 때문에
    // 접근 불가 따라서 private으로 설정
    // static -> static 공간에 올려서 , 같은 instance를 공유 위해
    static private SystemSpeaker instance;
    private int volume;
    
    //다른 곳에서 instance가 생성되지 않도록 private으로 설정
    private SystemSpeaker(){
     this.volume = 5;
       }
  
    // 생성자가 애초에 private이기 때문에 이 Method을 호출하기 위해서는 static으로 해야한다.
    // instance를 받기위해, 객체를 생성하는것이 아닌 , static을 함으로써 
    // instance를 생성하지 않고 접근 -> 코드 안에서 객체 생성
    public  static SystemSpeaker getInstance(){
        // instance가 null이면 새로 만들어주고 return 한다.
        if(instance == null){
            instance = new SystemSpeaker();
        }
        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    
}
