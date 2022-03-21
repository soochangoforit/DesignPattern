
package udp;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.net.DatagramPacket;

import java.net.DatagramSocket;

import java.net.InetAddress;

 

public class BasicUDPClient {

    DatagramSocket dsock;

    DatagramPacket sPack,rPack;

    InetAddress server; 

    int port = 7777;

    

    public BasicUDPClient(String ip, int port){

        try{

            server = InetAddress.getByName(ip); //서버 ip에 해당하는 컴퓨터를 나타내는 InetAddress 객체를 반환

            this.port = port; //서버의 포트 번호

            this.dsock = new DatagramSocket(); //DatagramSocket의 기본 생성자를 호출

            System.out.println(">> 서버에 접속합니다.");

            System.out.println(">> 서버에 전달할 메시지를 쓰고 Enter를 누르세요.");

            System.out.println(">> 종료하려면 quit를 쓰고 Enter를 누르세요" + "\n");

            

        } catch (Exception e) {

            System.out.println(e); //예외 발생시 try - catch를 통해서 에러를 잡는다.

        }
    }

    

    public void communicate(){

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //콘솔창에 입력하는것을 받는다.

            String strOut = null;

            while((strOut = br.readLine()) != null){ // 콘솔창에 입력한것이 null이 아니라면 true 반환 , while문 실행

                sPack = new DatagramPacket(strOut.getBytes(),strOut.getBytes().length, server, port); //DatagramPacket에 대한 생성자를 만든다.
                //DatagramPacket(송신될 데이터가 저장되어 있는 배열 , 배열의 크기 , 정보가 보내질 컴퓨터의 주소(서버주소), 서버 포트번호)

                dsock.send(sPack); //send(DatagramPacket sPack) : UDP 데이터그램(sPack)을 전송하는 send() 메소드

                

                if(strOut.equals("quit")) break; //만약 quit을 입력하면 서버 , 클라이언트 통신 종료

                

                byte[] buffer = new byte[1024]; //바이트 크기의 배열을 생성하고 크기는 1024이다.

                rPack = new DatagramPacket(buffer, buffer.length); //DatagramPacket는 데이터를 수신하는 응용 프로그램에서 사용하는 생성자
                //DatagramPacket(수신되는 데이터를 저장할 바이트 배열 , 배열의 크기)

                dsock.receive(rPack); //DatagramSocket에  정의된 메소드 , receive이다. UDP 데이터그램을 받아서 이미 존재하는 DatagramPacket 객체인 rPack에 저장한다.

                String strIn = new String(rPack.getData(),0,rPack.getData().length); //rPack으로 받은 데이터를 0번째 부터 , 길이만큼 읽어들인다. , 메시지의 내용을 저장

                System.out.println("[서버" + server + ": " + port + "]" + strIn);

            }

            System.out.println("UDP 클라이언트를 종료합니다."); //quit을 하기 전까지 계속 통신을 진행하고 quit를 입력하면 while문을 빠져나와 종료 문구를 출력한다.

            }catch(Exception e){

                System.out.println(e);

            }

        }

    public static void main(String[] args){

        BasicUDPClient client = new BasicUDPClient("113.198.234.106", 7777); //BasicUDPClient의 생성자를 호출한다. (서버의 ip주소 , 포트 번호)

        client.communicate(); //communicate를 실행한다.

    }
}
