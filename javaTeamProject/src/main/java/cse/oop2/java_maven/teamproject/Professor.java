package cse.oop2.java_maven.teamproject;
import java.util.Scanner;
import java.util.ArrayList;
import static cse.oop2.java_maven.teamproject.TestDrive.getConsoleInput;
import java.util.regex.Pattern;

public class Professor {
     private String PW;//비밀번호
    private String Pnum;//교수번호
    private String RSnum;//주민등록번호
    private String ProfName;// 교수이름
    private String Major;// 전공

    int i;
    int j;
    public Professor(){
        
    }
    
    
  public Professor(String Pnum, String RSnum,String ProfName,String Major){
        this.Pnum=Pnum;
        this.RSnum=RSnum;
        this.ProfName=ProfName;
        this.Major=Major;
        this.PW = RSnum.substring(RSnum.length()-7,RSnum.length());
        
    }
  public String getPW(){
      return PW;
  }
  public void setPW(String PW){
      this.PW=PW;
  }
  public String getPnum(){
      return Pnum;
  }
  public void setPnum(String Pnum){
      this.Pnum=Pnum;
  }
  public String RSnum(){
      return RSnum;
  }
  public void setRSnum(String RSnum){
      this.RSnum=RSnum;
  }
  public String getProfName(){
      return ProfName;
  }
  public void setProfName(String ProfName){
      this.ProfName=ProfName;
  }
public String getMajor(){
    return Major;
}
public void setMajor(String Major){
    this.Major=Major;
}

public void Pline(){
    System.out.println("===============================");

}

    
  
  
    Scanner sc = new Scanner(System.in);
        int sel=0; 
        
        
   
   //학생 명단      
   public void Allstudents(){          
       //강의 출력
       
       while(true){
       System.out.println("===============================");
       System.out.println("담당하는 강의 목록 출력");
          
           getLectureSelection();//담당하는 강의 전체 출력             
       Pline();
       System.out.print("명단 확인 할 강의를 선택하세요(종료 : 0) :");
         sel = sc.nextInt();
         sel-=1;
         if(sel==-1) //종료하려면 0 
                   break;
      
      
      Lecture selectedLecture = (Lecture)TestDrive.lecturesArray.stream().filter(
              e->e.getProfessor().equals(this)).toArray()[sel]; 
      // 메인에 있는 강의배열에서 담당교수가 선택한 값이 인덱스값과 같다면  따로 뽑아내서 배열로 변환
      
         
        System.out.println("<선택한 강의는 "+selectedLecture.getLectName()+" 입니다.>");
           //선택한 과목을 수강신청한 학생 출력
           
           //수강신청한 학생명단
           System.out.println("===============================");
        System.out.println("학생 목록 출력");
           
        ArrayList<Student> studList = selectedLecture.getRegisteredStudentArray();
        if(studList.size() == 0){
            System.out.println("강의를 수강하는 학생이 없습니다.");
        } 
        else{
            for(Student index : studList){
                System.out.println("학생 이름: "+index.getStuName() + "    " + "학번: "+index.getStuId());      
                // 학생리스트에서  인덱스값 받아 학생클래스에 있는 메소드(EX)학생이름, 학번)
                // 수강신청한 학생 리스트 출력
            }
        }
          
       }
     } 
        

   // 성적 입력
   public void InputGrade(){ 
       
        while(true){
            System.out.println("===============================");
               System.out.println("담당하는 강의 목록 출력");
               getLectureSelection();
               Pline();
               System.out.println("성적을 입력할 강의를 선택하세요(종료 : 0)");
               sel = sc.nextInt();
               sel-=1;
               if(sel==-1) //종료하려면 0 
                   break;
         
                //강의 선택
                 Lecture selectedLecture = (Lecture)TestDrive.lecturesArray.stream().filter(
                      e->e.getProfessor().equals(this)).toArray()[sel];
               System.out.println("<선택한 강의는 "+selectedLecture.getLectName()+" 입니다.>");

               ArrayList<Student> studList = selectedLecture.getRegisteredStudentArray();
               if(studList.size() == 0){
                   System.out.println("강의를 수강하는 학생이 없습니다.");
               } 
               else{
                    System.out.println("===============================");
                    System.out.println("학생 명단 출력");

                    for(Student index : studList){ 
                        System.out.println(Integer.toString(++j)+"번 학생 이름: "+index.getStuName() + "  학번: "+index.getStuId());
                    }
                   j=0;
                   Pline();
                
                //성적 입력할 학생 선택
                System.out.println("성적을 입력할 학생을 선택하세요: ");
                Pline();
                int i = sc.nextInt();
                i-=1;
                Pline();
                //성적 입력 
                System.out.print("성적을 입력하세요: ");
                
                sc.nextLine();
                String input = sc.nextLine();

                switch(input.charAt(0)){
                    case 'A':
                           selectedLecture.setScore(i, 4.0);
                           System.out.println("A 입력 완료했습니다.");
                        break;
                       case 'B':
                            selectedLecture.setScore(i, 3.0);
                            System.out.println("B 입력 완료했습니다.");
                           break;
                       case 'C':
                            selectedLecture.setScore(i, 2.0);
                            System.out.println("C 입력 완료했습니다.");
                           break;
                       case 'D':
                           selectedLecture.setScore(i, 1.0);
                           System.out.println("D 입력 완료했습니다.");
                           break;
                       case 'F':
                            selectedLecture.setScore(i, 0.0);
                            System.out.println("F 입력 완료했습니다.");
                           break;

                }
            }
        }       
    }
   
   
   
   
   
    // 출석부 조회
   public void Attendance(){
       while(true){
           System.out.println("===============================");
       System.out.println("담당 강의 출력");
       getLectureSelection();// 담당하는 강의 전체 출력  
       Pline();
       
       System.out.println("출석부를 확인할 강의를 선택하세요(종료 : 0)");
        sel = sc.nextInt();
        sel-=1;       
        Pline();
         if(sel==-1) //종료하려면 0 
                break;
         
         
       Lecture selectedLecture = (Lecture)TestDrive.lecturesArray.stream().filter(
              e->e.getProfessor().equals(this)).toArray()[sel];
       // 메인에 있는 강의배열에서 선택한 강의가 담당교수와 일치하다면 toArray()배열로 변환 
       Pline();
       System.out.println("<선택한 강의는 "+selectedLecture.getLectName()+" 입니다.>");
           
       //담당 강의 출석부 출력
       Pline();
       System.out.println("출석부 출력");    
       ArrayList<Student> studList = selectedLecture.getRegisteredStudentArray();
           
       for(Student index : studList){
           System.out.println("학생이름: "+ index.getStuName()+
            "  학번: "+index.getStuId()+"  학점: "+selectedLecture.getScore(index));              
        }  //저장된 학생리스트 studList에서 index 순서대로 값을 가져와서 학생의 이름, 학번, 학점을 출력한다. 
        
        }
    }
 
   

//담당하는 총 강의를 출력하는 메소드
   public void getLectureSelection(){       
       
        //담당하는 총 강의를 출력(강의 이름, 번호)
       TestDrive.lecturesArray.stream().filter(e->e.getProfessor().equals(this)).forEach(e->
            System.out.println( Integer.toString(++i) + "번 강의 이름 : " + e.getLectName()
                + "     "   + "강의 번호 : " + e.getLectNum()));    
         i=0;
   }
   
   public void changePassword() {
        //비밀번호 조건 : 알파벳, 숫자 7자리 문자열
        final String passwordPattern = "^[a-zA-Z0-9]{7}$";
        
        Pline();
        System.out.print("현재 비밀번호를 입력하세요. : ");
        if(!this.PW.equals(getConsoleInput())){
            Pline();
            System.out.println("비밀번호가 틀립니다.");
            return;
        }
 
        for(int i=0;i<5;i++){
            System.out.print("변경할 비밀번호를 입력하세요. : ");
            String input = getConsoleInput();
 
            if(!Pattern.matches(passwordPattern, input)){
                Pline();
                System.out.println("잘못된 비밀번호입니다. 비밀번호는 반드시 7자리의 영문자 및 숫자로 구성되야 합니다.");
                continue;
            }else{
                System.out.print("다시 한번 입력하세요. : ");
                if(input.equals(getConsoleInput())){
                    PW = input;
                    Pline();
                    System.out.println("비밀번호 변경이 완료되었습니다.");
                    return;
                }else{
                    Pline();
                    System.out.println("입력된 비밀번호가 일치하지 않습니다.");
                    continue;
                }
            }
        }
        Pline();
        System.out.println("5회 실패하셨습니다. 다시 시도해주세요.");
        return;
    }

}