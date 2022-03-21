package cse.oop2.java_maven.teamproject;

import static cse.oop2.java_maven.teamproject.TestDrive.getConsoleInput;
//import java.io.IOException;
//import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
 
    private String stuId;//학번(ID : S111)
    private String stuName;//이름
    private String Major;//학과
    private String stuRNum; //주민등록번호(초기 pw)
    private String stuNewPw; //new PW (새로 만든 pw)
 
 
 
    public String getStuId() {
        return stuId;
    }
 
    public void setStuId(String stuId) {
        this.stuId = stuId;
    }
 
    public String getStuName() {
        return stuName;
    }
 
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
 
    public String getMajor() {
        return Major;
    }
 
    public void setMajor(String Major) {
        this.Major = Major;
    }
 
    public String getStuRNum() {
        return stuRNum;
    }
 
    public void setStuRNum(String stuRNum) {
        this.stuRNum = stuRNum;
    }
 
    public String getStuNewPw() {
        return stuNewPw;
    }
 
    public void setStuNewPw(String stuNewPw) {
        this.stuNewPw = stuNewPw;
    }
 
    public Student(String stuId, String stuName, String Major, String stuPw) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.Major = Major;
        this.stuRNum = stuPw;
        this.stuNewPw = stuPw.substring(stuPw.length()-7,stuPw.length());
    }
 
    public void line(){  
        System.out.println("===============================");
    }
 
 
 public ArrayList<Bill> toBill = new ArrayList<>();
 
 //--------------------------------본격적인 시작----------------------------------------------------------------------------------------------------------------------------
    Scanner sc = new Scanner(System.in);
   
  
       public void changePassword() {
        //비밀번호 조건 : 알파벳, 숫자 7자리 문자열
        final String passwordPattern = "^[a-zA-Z0-9]{7}$";
        
        line();
        System.out.print("현재 비밀번호를 입력하세요. : ");
        if(!this.stuNewPw.equals(getConsoleInput())){
            line();
            System.out.println("비밀번호가 틀립니다.");
            return;
        }
        
        for(int i=0;i<5;i++){
            System.out.print("변경할 비밀번호를 입력하세요. : ");
            String input = getConsoleInput();
            
            if(!Pattern.matches(passwordPattern, input)){
                line();
                System.out.println("잘못된 비밀번호입니다. 비밀번호는 반드시 7자리의 영문자 및 숫자로 구성되야 합니다.");
                continue;
            }else{
                System.out.print("다시 한번 입력하세요. : ");
                if(input.equals(getConsoleInput())){
                    stuNewPw = input;
                    line();
                    System.out.println("비밀번호 변경이 완료되었습니다.");
                    return;
                }else{
                    line();
                    System.out.println("입력된 비밀번호가 일치하지 않습니다.");
                    continue;
                }
            }
        }
        line();
        System.out.println("5회 실패하셨습니다. 다시 시도해주세요.");
        return;
    } 
    
    
    
    
    
    
    public ArrayList<Lecture> mySubject = new ArrayList<>();
    
        public void setSubject(Lecture subject) { 
        this.mySubject.add(subject); //내가 수강 신청한 과목 배열에 과목을 추가한다.
    }

    public ArrayList<Lecture> getSubject() { 
        return mySubject; //내가 수강 신청한 과목 배열을 그대로 가져온다.
    }
 
    public ArrayList<Lecture> enrolledClassList() { //개설된 강의 목록을 출력 
        ArrayList<Lecture> searchedArray = new ArrayList<>(Arrays.asList(
                TestDrive.lecturesArray.stream().filter(e->e.isSemesterCheck()).toArray(Lecture[]::new   )));
         line();
           
        searchedArray.forEach(e -> System.out.println(
                (TestDrive.lecturesArray.indexOf(e) + 1)+"번 강좌번호 :   " 
                + e.getLectNum() + " 과목명 :   " 
                + e.getLectName() + " 교수명 :   "
                + e.getProfname()
        ));
        line();
        return searchedArray;
    }
     
  public void signStud(){ 
        
        int isub; //개설된 강의 목록 중에서 몇번째 강의를 선택할건지...
        String str;
        boolean bflag = false;
        
        while (!bflag) {
            enrolledClassList(); //현재 개설된 강좌 리스트 출력

            System.out.println(">> 신청하고자 하는 과목의 순서번호를 눌러주세요. , 0을 누르면 뒤로 돌아갑니다."); 
            line();
            
           try{
            isub = Integer.parseInt(getConsoleInput());
           
             if (isub == 0) { 
                 return;
             } 

                
             
                 isub -= 1;
                Lecture lecture = TestDrive.lecturesArray.get(isub);
                                   

                if (!overlapChk(lecture)) 
                { //중복으로 신청을 안했으면 밑으로 내려온다.
                   
                    
                    //최대 18학점까지만 신청 가능하게
                    int creditCount = 0;
                    for (int i = 0; i < mySubject.size(); i++) {
                        creditCount += mySubject.get(i).getCredit(); 
                    }
                    
                        //최대 18학점 2,3,3,2
                        if (18 - creditCount < TestDrive.lecturesArray.get(isub).getCredit()) { //남은 학점 0,1,2일때
                            System.out.println("최대 18학점만 수강 가능합니다. 0번을 누르면 뒤로 돌아갑니다.");
                            System.out.println("현재 수강 신청한 학점 수: " +  creditCount);
                            line();
                            int zero = Integer.parseInt(getConsoleInput());
                            
                            if (zero == 0) {
                                return;
                            }
                        }  
                        
                     //최대인원으로 수강 신청시 신청 불가능 하게 --> 그렇지 않을 경우 추가한다.
                     int a = lecture.returnSizeOfCourse();
                     //System.out.println(a);
                     
                     if(TestDrive.lecturesArray.get(isub).getMax() == a){
                         System.out.println("최대 수강인원을 초과하였습니다. 다른 강의 번호를 선택하세요. 0을 누르면 뒤로 돌아갑니다.");
                         continue; //반복문 while를 나가고 다시 while로 들어온다.
                     }
                    
                        this.setSubject(TestDrive.lecturesArray.get(isub)); //중복 아닐시 우선은 추가를 한다.
                        lecture.getRegisteredStudentArray().add(this);   //registered 배열에 학생 객체를 넣는다.
                        lecture.addScore();                              //신청한 학생의 성적 공간만 null
                        
                        line();
                        str = "선택하신 과목은 " + lecture.getLectName()+ "입니다. \n해당 교과목의 담당 교사는 "
                                + TestDrive.lecturesArray.get(isub).getProfname() + "입니다.";
                        
                        System.out.println(str);
                        
                        
                }else { //중복 방지
                    line();
                    System.out.println("이미 추가된 과목입니다.");
                   
                }
             }catch(IndexOutOfBoundsException e ){
                 System.out.println("개설된 강의만 신청이 가능합니다. 숫자를 다시 입력하세요");
             }catch(NumberFormatException ex){
                 System.out.println("숫자만 입력이 가능합니다.");
             }
            
        }
    }
    
    
      private boolean overlapChk(Lecture subject) { 
            
      if(this.mySubject.contains(subject)) {
         return true;} //중복
                else{
         return false; }//중복 X
   }
     
        
    public void printMyClassList() {  //내가 신청한 강의 목록 출력
        line();
        System.out.println("<이번 학기 수강 목록>");
        
        for (int i = 0; i < this.mySubject.size(); i++) { 
            int e = i +1;  //1번부터 출력 
            
            String str;
            str = e +"번 과목 : " + this.mySubject.get(i).getLectName()
                    + "/ 교사명 : " + this.mySubject.get(i).getProfname();
            System.out.println(str); 
        }
    }

    public void printMyClassGradeList() {

        while (true) {
            printMyClassList(); //내가 신청한 강의 목록 출력

            System.out.println("점수를 확인하고자 하는 번호를 입력하세요, 0을 누르면 뒤로 돌아갑니다 : "); //1번. 비주얼 프로그래밍
            try {
                int igrade = Integer.parseInt(getConsoleInput());

                if (igrade == 0) {
                    return;
                }

                igrade -= 1; //1번을 입력하면 배열상으로 0번째 있는것을 출력하기 위해 -1을 한다.
                line();
                if (this.mySubject.get(igrade).getScore(this) != -1.0) {
                    System.out.println("과목 : " + this.mySubject.get(igrade).getLectName()
                            + " 교사명 : " + this.mySubject.get(igrade).getProfname()
                            + "   취득한 점수 : " + this.mySubject.get(igrade).getScore(this));
                } else {
                    System.out.println("아직 성적 입력이 되지 않았습니다.");

                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못 누르셨습니다. 신청된 과목의 번호를 잘 확인하세요");
            } catch (NumberFormatException ex) {
                System.out.println("숫자만 입력하세요");
            }
        }

    }
    
    public void addBill(String lectureNumber, double toPay){ //내가 수강 신청한 과목의 강의번호를 넣는다. ??그러면 수강신청할때마다 강의 번호를 넣어야 하는건지??
        toBill.add(new Bill(lectureNumber,toPay)); //String 데이터 타입
    }
    
   
    
    public void printBill(){
        line();
        System.out.println("지불하셔야 할 수강료는 다음과 같습니다.");
        
        int totalCost = 0;
        for(Bill i : toBill){
            Lecture lect = TestDrive.lecturesArray.stream().filter(e->e.getLectNum().equals(i.getLectureNumber())).findFirst().orElse(null);//내가 추가한 강의 번호가 있으면 그 Lecture 객체를 넣는다.
            if(lect==null){
                System.out.println("강의가 존재하지 않습니다.");
            }else{
                System.out.printf("강의 이름 : %s, 수강료 : %,.1f 원 입니다.", lect.getLectName(),i.getBillingAmount());
                System.out.println();
                totalCost+=i.getBillingAmount();
            }
        }
        
        line();
        System.out.printf("총 수강료는 %,d 원입니다.",totalCost);
        System.out.println("");
        }    
}
 
class Bill{
    private String lectureNumber = "";
    private double billingAmount = 0;
    
    public Bill(String lectureNumber, double billingAmount){
        this.lectureNumber = lectureNumber;
        this.billingAmount = billingAmount;
    }

    public String getLectureNumber() {
        return lectureNumber;
    }

    public double getBillingAmount() {
        return billingAmount;
    }
    
}