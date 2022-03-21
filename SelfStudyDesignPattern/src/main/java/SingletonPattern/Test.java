package SingletonPattern;

public class Test {

    public static void main(String[] args) {
        //외부에서 생성하지 못하도록, 해당 Class 생성자
        // private으로 지정
        // SystemSpeaker speaker = new SystemSpeaker();
        
        //speaker1과 speaker2는 static 공간에 있는 같은 instance를 공유하고 있다.
        SystemSpeaker speaker1 = SystemSpeaker.getInstance();
        SystemSpeaker speaker2 = SystemSpeaker.getInstance();
        
        // static 공간의 instance의 필드를 공유했기 때문에, 같은 필드값을 출력
        speaker1.setVolume(12);
        System.out.println(speaker1.getVolume());        
        System.out.println(speaker2.getVolume());
        
        System.out.println(speaker1.equals(speaker2));
        //주소값을 찍어보면 같은 static 공간의 instance를 가져오는것을 확인 가능
        System.out.println(speaker1);
        System.out.println(speaker2);
        
    }
    
}
