
package cse.oop2.ch11;

import javax.sound.midi.*;

public class MiniMusicCmdLine {
    
    public static void main(String[] args){
        MiniMusicCmdLine mini = new MiniMusicCmdLine(); //MiniMusicCmdLine에 대한 인스턴스 만든다.
        if(args.length < 2){ //args 는 String[] , String 배열이다. args가 2보다 적으면 
            System.out.println("Don't forget the instrument and note args");
         
        }else{
            int instrument = Integer.parseInt(args[0]); //args[] 첫번째로 들어오는 값은 악기를 지정
            int note = Integer.parseInt(args[1]);       //args[] 두번째로 들어오는 값은 음의 높이를 지정
            mini.play(instrument,note);
        }
    }
    
    public void play(int instrument, int note){
        
       try{
            Sequencer sequencer = MidiSystem.getSequencer(); //singleton pattern 이다.
            sequencer.open();
            
            Sequence  seq  = new Sequence(Sequence.PPQ,4);  //새로운 Sequence만들기 , PPQsms Pulse Per Quarter를 의미한다.
            Track track = seq.createTrack();                //seq에 track을 만든다.
            
            MidiEvent event = null;
            
            //새롭게 추가 되는 부분
            ShortMessage first = new ShortMessage();       //ShortMessage에 대한 인스턴스 변수를 만든다. ShortMessage는 내가 표현하고자 하는 소리의 형태이다.
            first.setMessage(192,1,instrument,0);          //192 --> Change라는 의미를 담고 있다. 즉 사용자가 입력한 악기로 변경한다는 의미를 가지고 있다. 
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);                   //음의 정보를 담고 있는 MidiEvent 데이터 타입의 changeInstrument를 track에 추가한다.
            
            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,note,100);          //ShortMessage.NOTE_ON 이랑 같은 의미 , 1번 채널 음의 높이 note를 이제 마음대로 바꿀수 있다. 
            MidiEvent noteOn = new MidiEvent(a,1); //소리가 나게 하는 MidiEvent를 track에 넣었다. 
            track.add(noteOn);
            
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,note,100);               //ShortMessage.NOTE_OFF 이랑 같은 의미
            MidiEvent noteOff = new MidiEvent(b, 16);   //소리가 더 이상 나지 않는 MidiEvent를 track에 추가
            track.add(noteOff); 
            
            sequencer.setSequence(seq);  //setSequence는 CD를 넣는것이다. sequencer에 seq를 넣고 seq 안에는 음의 정보가 담긴 track이 있다.
            
            sequencer.start(); //start를 하게 되면 소리가 나게 된다 
            
            Thread.sleep(5000); //1초 정도 기다려줬다가 sequencer를 종료하게 된다. 
            sequencer.close();
            System.exit(0); //시스템을 종료하게 한다. 이 부분은 안적어도 괜찮다. 
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
