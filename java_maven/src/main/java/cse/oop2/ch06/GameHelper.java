
package cse.oop2.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class GameHelper {
    
    private static final String alphabet = "abcdefg";
    private final int gridLength = 7; //앞으로 변하지 않음으로 앞에 final로 붙여준다. 클래스 이름 앞이나 메소드 앞에서도 사용 할 수 있다.
    
    private int gridSize = 49; //7*7 그리드 여기서는 1차원 배열로 사용할것이다.
    private final int[] grid = new int[gridSize]; //49개의 int 배열 모두 0으로 초기화 
    private int comCount = 0; //3개의 연속된 문자,숫자열의 개수, 즉 3*1의 경우 우리는 지금 (3*1) * 3, 3개의 묶음을 가지는것을 3개를 만들려고 한다.
    
    public String getUserInput(String prompt){ //getUserInput("영어 한글자와 숫자를 입력하세요")
        String inputLine = null;
        System.out.print(prompt + " "); //영어 한글자와 숫자를 입력하세요 를 출력한다.
        
        try{
            BufferedReader is =new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine(); //사용자가 입력한 문자 + 숫자를 inputLine에 String 형식으로 넣는다.
            if(inputLine.length() == 0){
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase(); //사용자가 넣은값을 전부 소문자로 바꾸어서 처리한다.
    }
    
    public ArrayList<String> placeDotCom(int comSize){ //comSize는 3으로 가정하고 코드를 보겠다. 우리가 앞으로 3*1을 3개를 만들겠다라는 의미이다.
        
        ArrayList<String> alphaCells = new ArrayList<String>(); //alphaCells는 String 형태를 하는 배열이다.
        String temp = null;
        int[] coords = new int[comSize]; //comSize 는 3이다. 3개의 장소 정보가 coords 변수에 들어가게 된다., 즉 location이 3개 들어 갈 수 있는 배열이다.
        int attempts = 0;
        boolean success = false; //true가 되면 3개의 장소를 제대로 찾은것이다. 
        int location = 0; //임의로 지정된 컴퓨터가 정하는 위치 3개가 들어갈것이다.
        
        comCount++; //앞서 private으로 0으로 설정 놓았다. comCount : 1,2,3 순서로 증가 , 이제 우리가 만들려고하는것은 총 (3*1) 3개를 만들것이다.
        int incr = 1; //comCount가 짝수일 경우 incr = 1이다.
        if((comCount %2) == 1){ //comCount가 홀수이면 세로로 , 짝수이면 가로로 배치 , 홀수이면 incr = 7이고 짝수이면 incr = 1이다. %는 나머지 계산을 의미한다.
            incr = gridLength; //gridLength는 7으로 정의했다. 홀수일때 (세로 배치)
        }
        
        //본격적으로 시작
        while(!success & attempts++ < 200) { //200번 동안 반복해서 찾겠다. , 한번 success가 ture 되면 빠져나온다.
            
            location = (int)(Math.random()*gridSize); //gridSize = 49이다. 0 ~48까지 랜덤넘버 정한다.
            
            int x = 0; //DotCom의 위치를 나타낸다.  0,1,2 이런식으로 해서
            
            success = true;
            while(success && x < comSize) { //comSize 는 현재 3이다. x는 0,1,2까지만 들어간다. 3이 들어가면 comSize가 3이므로 false가 되고 while문 종료한다. , comSize는 우리가 (3*1)를 3개를 만들겠다는 의미.
                if(grid[location]==0){ //gird는 현재 49개를 가지는 행렬이다. location을 현재 Math.random()으로 인한 4로 가정, 첫번째로 사직했기 때문에 gird[4]에는 아무것도 없는 = 0 상태이다. ,gird.length가 값이 0으로 초기화 되어있다. 현재 DotCom이 배치되지 않았다 의미. 
                    coords[x++] = location; //coords[]는 3개가 들어갈수 있는 배열 , location 4를 넣는다. , coords[0] = 4이다. , x는 0으로 반환하고 +1를 한다. x는 0,1,2가 들어간다. ,,, ++x를 하게 되면 coords[1]이 되므로 맞지가 않다. 주의하자!!!
                    location += incr; //location이 incr 만큼 더해져야 한다. 왜냐하면 처음 홀수는 세로로 배치하고 +7을 해줘야한다. location은 그러면 4 ,11 ,18의 값을 갖게 된다. coords 3칸이 전부 다 찼다.
                    if(location >= gridSize){ //gridSize는 현재 49이다. 바운더리 check 하는것이다. 예를들어 location이 임의의 숫자 47을 배정 받았고 세로로 만들어지면 47+7= 54 > girdSize(49)를 초과하므로 종료한다.
                        success = false;
                    }
                    if(x > 0 & (location % gridLength == 0)) { //바운더리 체크한다. gridLength는 현재 7이다. location을 7로 나누었을때 나머지가 0이면 ,즉 location이 7의 배수로만 이루어져 있을때 종료된다
                        success = false;
                    } //else { //이부분은 필요가 없는 부분이다. 바운더리 검사를 하고 else로 넘어가는데 success가 false가 되면 while(success && x < comSize)부분이 한번 설정된 값이 세로 , 가로에 따라 incr값이 3번 더해져애 하는데 false가 되버리면 한번만 더 함으로 맞지가 않다.
                      //  success = false;
                    //} 여기서 success가 false이면 한번만 돌리고 나오고 이 succeess는 지역변수이기 때문에 while(!success & attempts++ < 200)에서 !false = true가 되기때문에 계속 순환해서 attempts가 200을 넘어가버린다. , 기존에 정해진 location에서 +7,+7이 되어야 하는데 계속 돌아버리면 location 값들이 계속 변하게 된다.
                }
            } //end of while , succes가 false되면 종료되는것이 아니라 x가 3이 되면 comSize와 같게 되면 종료되게 한다. , 그리고 여기서 (3*1)을 3개를 만들어야 하는데 1개만 만드는 이유는 main에서 3개의 객체를 만들고 각 개체에 따로 실행을 할려고 하기 때문이다.
        
            
            
            //ArrayList<String> placeDotCom()에 대한것은 뒤에 계속된다. , 현재 앞까지 세로에 대한 grid index[4,11,18]을 구했다.
            //뒤에 나올부분은 4,11,18 숫자에 대해 영문자를 추가할것이다.
            
             x = 0; // 앞에 있는 X는 0,1,2로 진행되면서 3이 되는 순간 빠져나왔고 현재 x는 다시 0으로 초기화한 값이다.
            int row = 0; //0으로 초기화 ,현재 우리가 생각하는 행은 숫자이다.
            int column = 0; //0으로 초기화 , 현재 우리가 생각하는 열은 영문자이다.
            
            while(x < comSize) { //comSize는 3이다. x는 0,1,2 으로 들어간다.
                grid[coords[x]] = 1; //grid는 0~48을 의미하고  coords[0,1,2]의 값 4,11,18은 grid[49]의 배열에서 1로 설정이 된다. 원래는 grid[49]의 모든 값들이 0으로 설정 되었다. 그 값들을 1로 바꾸게 된다. 현재 세로로 나타내지기 때문에 +7씩 한것이다.
                row = (int)(coords[x] / gridLength); //7로 나누어서 몫을 구하는거다. 현재 coords[x]에 저장되어 있는 4,11,18에 대한 몫을 순서대로 0 , 1 , 2을 row에 넣는다. (숫자행) , /를 한다는것은 몫을 구하는것이다.
                column = coords[x] % gridLength; // 현재 coords[x]에 저장되어 있는 4,11,18에 대한  나머지를 7로 나누어서 나머지를 구한다. 순서대로 4 , 4 , 4를 column에 넣는다. (문자열) 이말은 세로일때는 하나의 열에서 같은 문자를 갖는다.
                temp = String.valueOf(alphabet.charAt(column)); //"abcdefg" 중 하나 선택 , column이 4이고 0부터 시작하므로 alphabet 중에서 String e를 선택한다. e는 char로 저장되지만 String.valueOf에 의해 String으로 바뀐다. temp에 넣는다.
                
                alphaCells.add(temp.concat(Integer.toString(row))); //temp (e) 에다가 concat (갖다 붙이다.) 뭐를 row에 해당하는것을 Integer.toString로 인해 row는 Int -> String 형태로 바뀌게 된다. 현재 0,1,2이다. .concat은 문자열을 붙일때 사용한다.
                x++;//alphaCells는 현재 ArrayList이다. 0,1,2 3번 반복 함으로써 alphaCells 배열 여기에  e0 , e1 , e2 가 저장된다.
            }
            
        }
        //다시 한번 실행하면 comCount는 2로 바뀐다. incr는 1로 바뀐다. -> comCount는 2이기 때문에 이번에는 incr가 1로 유지된다. 이번에는 가로로 배치한다. 한번더 실행할때는 다른 객체에서 시작한다.
        return alphaCells; //e0 , e1 , e2된다.
    } //end of placeDotCom()
} //GameHelper 클래스 종료
