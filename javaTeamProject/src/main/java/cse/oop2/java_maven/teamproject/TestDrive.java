package cse.oop2.java_maven.teamproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class TestDrive {
    static ArrayList<Student> studentsArray = new ArrayList<>();
    static ArrayList<Lecture> lecturesArray = new ArrayList<>();
    static ArrayList<Professor> professorsArray = new ArrayList<>();
    static ArrayList<HEmployee> hEmployeesArray = new ArrayList<>();
    static ArrayList<GEmployee> gEmployeesArray = new ArrayList<>();
   
    public static void main(String[] args){
        initialize();
        login();
    }
   
   
   
    public static void login(){
        final String idInputPattern = "^[A-Z]{1}\\d{3}$";
       
        String idInput;
        while(true){
        //ID 로그인
        while(true){
            System.out.println("===============================");
            System.out.print("ID를 입력해주세요 : ");
            idInput = getConsoleInput();
           
            if(!Pattern.matches(idInputPattern, idInput)){
                System.out.println("학번 입력이 잘못되었습니다. 다시 입력해 주세요.");
            }else{
                break;
            }
        }
        final String finalIdInput = idInput;
        //비밀번호 검사
        switch(idInput.charAt(0)){
            case 'S':
                Student studentToLogin = studentsArray.stream().
                        filter(e->e.getStuId().equals(finalIdInput)).findFirst().orElse(null);
               
                if(studentToLogin==null){
                    System.out.println("존재하지 않는 사용자입니다. 다시 시도하세요.");
                }else{
                    System.out.print("비밀번호를 입력하세요 : ");
                    String pwInput = getConsoleInput();
                   
                    if(!studentToLogin.getStuNewPw().equals(pwInput)){
                        System.out.println("비밀번호가 틀렸습니다.");
                    }else{
                        studentMenu(studentToLogin);
                    }
                }
                break;
               
            case 'P':
                Professor professorToLogin = professorsArray.stream().
                        filter(e->e.getPnum().equals(finalIdInput)).findFirst().orElse(null);
               
                if(professorToLogin==null){
                    System.out.println("존재하지 않는 사용자입니다. 다시 시도하세요.");
                }else{
                    System.out.print("비밀번호를 입력하세요 : ");
                    String pwInput = getConsoleInput();
                   
                    if(!professorToLogin.getPW().equals(pwInput)){
                        System.out.println("비밀번호가 틀렸습니다.");
                    }else{
                        professorMenu(professorToLogin);
                    }
                }
                break;
               
            case 'H':
                HEmployee hEmployeeToLogin = hEmployeesArray.stream().
                        filter(e->e.getNumber().equals(finalIdInput)).findFirst().orElse(null);
               
                if(hEmployeeToLogin==null){
                    System.out.println("존재하지 않는 사용자입니다. 다시 시도하세요.");
                }else{
                    System.out.print("비밀번호를 입력하세요 : ");
                    String pwInput = getConsoleInput();
                   
                    if(!hEmployeeToLogin.getPw().equals(pwInput)){
                        System.out.println("비밀번호가 틀렸습니다.");
                    }else{
                        hEmployeeMenu(hEmployeeToLogin);
                    }
                }
                break;
               
            case 'G':
                GEmployee gEmployeeToLogin = gEmployeesArray.stream().
                        filter(e->e.getIdNumber().equals(finalIdInput)).findFirst().orElse(null);
               
                if(gEmployeeToLogin==null){
                    System.out.println("존재하지 않는 사용자입니다. 다시 시도하세요.");
                }else{
                    System.out.print("비밀번호를 입력하세요 : ");
                    String pwInput = getConsoleInput();
                   
                    if(!gEmployeeToLogin.getPassword().equals(pwInput)){
                        System.out.println("비밀번호가 틀렸습니다.");
                    }else{
                        gEmployeeMenu(gEmployeeToLogin);
                    }
                }
                break;
            default:
                System.out.println("학번 입력이 잘못되었습니다. 다시 입력해 주세요.");
                break;
        }
    }
    }
    

   
    public static void studentMenu(Student loginBy){
        System.out.println(loginBy.getStuName() + "님 안녕하세요.");
        int menuInput=0;
       
        while(true){
            System.out.println("===============================");
            System.out.println("1. 수강 신청");
            System.out.println("2. 수강목록 확인");
            System.out.println("3. 성적 조회");
            System.out.println("4. 청구서 출력");
            System.out.println("5. 비밀번호 변경");
            System.out.println("6. 로그아웃");
            System.out.println("===============================");
            
            try{
                menuInput = Integer.parseInt(getConsoleInput());
            }
            catch(NumberFormatException e){
                System.out.println("숫자만 입력하실 수 있습니다.");
                continue;
            }
            switch(menuInput){
                case 1:
                    //수강신청 메소드 호출
                    loginBy.signStud();
                    break;
                case 2:
                    //수강목록 메소드 호출
                    loginBy.printMyClassList();
                    break;
                case 3:
                    //성적 조회 메소드 호출
                    loginBy.printMyClassGradeList();
                    break;
                case 4:
                    //청구서 출력
                    loginBy.printBill();
                    break;
                case 5: 
                    //비밀번호 변경
                    loginBy.changePassword();
                    break;
                case 6:
                    //로그아웃
                    return;
            }
        }
    }
   
    public static void professorMenu(Professor loginBy){
        System.out.println(loginBy.getProfName() + "님 안녕하세요.");
        int menuInput=0;
       
        while(true){
            System.out.println("===============================");
            System.out.println("1. 학생 명단");
            System.out.println("2. 성적 입력");
            System.out.println("3. 출석부 조회");
            System.out.println("4. 비밀번호 변경");
            System.out.println("5. 로그아웃");
            System.out.println("===============================");
            try{
                menuInput = Integer.parseInt(getConsoleInput());}
            catch(NumberFormatException e){
                System.out.println("숫자만 입력하실 수 있습니다.");
                continue;
            }
            switch(menuInput){
                case 1:
                    //학생 명단 메소드 호출
                    loginBy.Allstudents();
                    break;
                case 2:
                    loginBy.InputGrade();
                    break;
                case 3:
                    //출석부 조회 메소드 호출
                    loginBy.Attendance();
                    break;
                case 4:
                    loginBy.changePassword();
                    break;
                case 5:
                    //로그아웃
                    return;
            }
        }
    }
   
    public static void gEmployeeMenu(GEmployee loginBy){
        System.out.println(loginBy.getName() + "님 안녕하세요.");
        int menuInput=0;
       
        while(true){
            System.out.println("===============================");
            System.out.println("1. 강의 추가");
            System.out.println("2. 강의 삭제");
            System.out.println("3. 수강료 청구서 출력");
            System.out.println("4. 강의 개설 여부 변경");
            System.out.println("5. 비밀번호 변경");
            System.out.println("6. 로그아웃");
            System.out.println("===============================");
            try{
                menuInput = Integer.parseInt(getConsoleInput());}
            catch(NumberFormatException e){
                System.out.println("숫자만 입력하실 수 있습니다.");
                continue;
            }
            switch(menuInput){
                case 1:
                    //강의 추가 메소드 호출
                    loginBy.addCourse(lecturesArray, professorsArray);
                    break;
                case 2:
                    //강의 삭제 메소드 호출
                    loginBy.removeCourse(lecturesArray);
                    break;
                case 3:
                    //수강료 청구서 출력 메소드 호출
                    loginBy.printBill(lecturesArray, studentsArray);
                    break;
                case 4:
                    //강의 개설 여부 변경 메소드 호출
                    loginBy.setLecturesCheck(lecturesArray);
                    break;
                case 5:
                    //비밀번호 변경 메소드 호출
                    loginBy.changePassword();
                    break;
                case 6:
                    //로그아웃
                    return;
            }
        }
    }
   
    public static void hEmployeeMenu(HEmployee loginBy){
        System.out.println(loginBy.getName()+ "님 안녕하세요.");
        int menuInput=0;
       
        while(true){
            System.out.println("===============================");
            System.out.println("1. 사용자 등록");
            System.out.println("2. 사용자 삭제");
            System.out.println("3. 사용자 조회");
            System.out.println("4. 사용자 수정");
            System.out.println("5. 로그아웃");
            System.out.println("===============================");
            try{
                menuInput = Integer.parseInt(getConsoleInput());}
            catch(NumberFormatException e){
                System.out.println("숫자만 입력하실 수 있습니다.");
                continue;
            }
            switch(menuInput){
                case 1:
                    //사용자 등록 메소드 호출
                    loginBy.addUser();
                    break;
                case 2:
                    //사용자 삭제 메소드 호출
                    loginBy.deleteUser();
                    break;
                case 3:
                    //사용자 조회 메소드 호출
                    loginBy.checkUser();
                    break;
                case 4:
                    //사용자 수정 메소드 호출
                    loginBy.reviseUser();
                    break;
                case 5:
                    //로그아웃
                    return;
            }
        }
    }
   
    public static String getConsoleInput(){
        try{
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
           
            return inputStream.readLine();
        }
        catch(IOException e){
            System.err.print("에러가 발생했습니다 : " + e);
            return null;
        }
    }
    
    public static void initialize(){
        //This method is for initializing test program.
        //이 메소드는 테스트 프로그램의 초기화를 위해 생성되었습니다.
        //If you want to build this project, please comment out this method's call section.
        //만약 이 프로젝트를 빌드하고 싶으시다면, 이 메소드 호출부를 전부 주석처리 해주십시오.
        try{
            studentsArray.add(new Student("S101", "권성율", "전산학과", "9902101567848"));
            studentsArray.add(new Student("S102", "김유민", "전자공학과", "0104042123456"));
            studentsArray.add(new Student("S103", "송준섭", "화학공학과", "9906081891234"));
            studentsArray.add(new Student("S104", "이수찬", "기계공학과", "9808161765432"));
            studentsArray.add(new Student("S105", "조진혁", "항공우주공학과", "0111301321987"));
        
            //Professor(String Pnum, String RSnum,String ProfName,String Major)
            professorsArray.add(new Professor("P101", "6705151467913", "a", "전산학과"));
            professorsArray.add(new Professor("P102", "6302151594682", "박광철", "전자공학과"));
            professorsArray.add(new Professor("P103", "6908251123465", "김가림", "화학공학과"));
            professorsArray.add(new Professor("P104", "6507141235689", "김철수", "기계공학과"));
            professorsArray.add(new Professor("P105", "6802192946173", "홍길순", "항공우주공학과"));
            
            //HEmployee(String name, String number, String residentnumber) 
            hEmployeesArray.add(new HEmployee("H관리자1", "H101", "8905172947613"));
            hEmployeesArray.add(new HEmployee("H관리자2", "H201", "9112131528461"));
            
            // GEmployee(String idNumber, String name, String residentNumber) 
            gEmployeesArray.add(new GEmployee("G101", "G관리자1", "8702232661843"));
            gEmployeesArray.add(new GEmployee("G102", "G관리자2", "9409191512346"));
            
            //Lecture(String LectName, String Major, String Introduction, String LectNum, int Credit, int Min, int Max, double Tuition, Professor professor)
            lecturesArray.add(new Lecture("전산개론", "전산학과", "전산 개념에 대한 강의", "20213", 3, 1, 3, 400000, professorsArray.get(0)));
            lecturesArray.add(new Lecture("전자기학", "전자공학과", "전자의 흐름 이해에 대한 강의", "20216", 3, 1, 3, 300000, professorsArray.get(1)));
            lecturesArray.add(new Lecture("기계재료", "기계공학과", "기계 재료 개념에 대한 강의", "20217", 3, 1, 3, 400000, professorsArray.get(3)));
            lecturesArray.add(new Lecture("공학수학", "전자공학과", "공학수학 개념에 대한 강의", "20218", 3, 1, 3, 600000, professorsArray.get(1)));
            lecturesArray.add(new Lecture("전자공학", "전자공학과", "전자공학 개념에 대한 강의", "20219", 3, 1, 3, 300000, professorsArray.get(1)));
            lecturesArray.add(new Lecture("화학공학", "화학공학과", "화학공학 개념에 대한 강의", "20220", 3, 1, 3, 400000, professorsArray.get(2)));
            lecturesArray.add(new Lecture("항공우주", "항공우주공학과", "항공우주 개념에 대한 강의", "20221", 3, 1, 3, 400000, professorsArray.get(4)));
            lecturesArray.add(new Lecture("기계구조", "기계공학과", "기계 구조에 대한 강의", "20425", 4, 1, 4, 600000, professorsArray.get(3)));
        }catch(Exception e){
            System.err.println(e);
        }
    }
}