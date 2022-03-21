
package cse.oop2.ch11;

import javax.sound.midi.*;


public class MiniMiniMusicApp {
    
    public static void main(String[] args){
        MiniMiniMusicApp mini = new MiniMiniMusicApp(); //MiniMiniMusicApp를 만들고 play 한다.
        mini.play();
    }
    
    public void play(){
        
        try{
            Sequencer sequencer = MidiSystem.getSequencer(); //singleton pattern
            sequencer.open();
            
            Sequence  seq  = new Sequence(Sequence.PPQ,4); //새로운 Sequence만들기 , PPQsms Pulse Per Quarter를 의미한다.
            
            Track track = seq.createTrack(); //Sequence에 새로운 Track 추가하기
            
            MidiEvent event = null;
            
            ShortMessage a = new ShortMessage();   //메시지를 만든다.
            a.setMessage(144,1,44,100);            //ShortMessage.NOTE_ON 이랑 같은 의미 , 1번 채널, 44의 음의 높이 , 길이를 100을 한다. 44--> 80으로 바꾸면 악기가 달라지면서 음이 달라진다. 
            MidiEvent noteOn = new MidiEvent(a,1); //소리가 나게 하는 MidiEvent를 noteOn으로 정의 . 
            track.add(noteOn);                     //소리가 나게 하는 MidiEvent를 noteOn으로 정의 track에 넣었다. 
            
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,44,100);                 //ShortMessage.NOTE_OFF 이랑 같은 의미 , 1번 채널 , 44의 음의 높이 , 길이 100
            MidiEvent noteOff = new MidiEvent(b, 16);   //소리가 더 이상 나지 않는 MidiEvent를 noteOff로 정의 , MidiEvent(MidiMessage message, long tick)으로 정의 됨
            track.add(noteOff);                         //소리가 더 이상 나지 않는 MidiEvent를 noteOff로 정의 track에 추가
            
            sequencer.setSequence(seq);  //setSequence는 CD를 넣는것이다. Sequence 데이터 타입을 가지는 인스턴스 변수 seq는 track을 포함하고 있다.
            
            sequencer.start(); //start를 하게 되면 소리가 나게 된다 
            
            Thread.sleep(1000); //1초 정도 기다려줬다가 sequencer를 종료하게 된다. 
            sequencer.close();
            System.exit(0); //시스템을 종료하게 한다. 이 부분은 안적어도 괜찮다. 
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
