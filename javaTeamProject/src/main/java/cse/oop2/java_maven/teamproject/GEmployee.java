package cse.oop2.java_maven.teamproject;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
import java.util.Arrays;
import java.util.ArrayList;
 
import java.util.regex.Pattern;
import java.util.StringTokenizer;

public class GEmployee{
 
 
    //강좌번호, 이름, 학과, 학점, 설명, 담당 교수, 최소, 최대 학생수
 
 
    //variables
    private String idNumber;
    private String name;

    
    private String residentNumber;
    private String password;

    public String getGnumber() {
        return idNumber;
    }
    public void setGnumber(String Gnumber) {
        this.idNumber = idNumber;
    }
     public String getGname() {
        return name;
    }
    public void setGname(String Gname) {
        this.name = name;
    }
    public String getGRnumber() {
        return residentNumber;
    }
    public void setGRnumber(String GRnumber) {
        this.residentNumber = residentNumber;
    }
 
    //Constructor
 
    //들어온 parameters를 각각 해당 클래스의 개인 정보 부분에 입력, 이 정보들은 바뀌지 않음
    //String password를 초기 설정값인 주민번호 뒷자리 7자리로 자동 할당
    public GEmployee(String idNumber, String name, String residentNumber) throws Exception{
        //유효성 검사. ID와 주민번호 형식을 검사함.
        //패턴을 String으로 생성, 검사한다.
        final String idPattern = "^[A-Z]{1}\\d{3}$";
        final String residentNumberPattern = "^\\d{6}[0-4]\\d{6}$";
 
        if(Pattern.matches(idPattern,idNumber)&&Pattern.matches(residentNumberPattern, residentNumber)){
            this.idNumber = idNumber;
            this.name = name;
            this.residentNumber = residentNumber;
            //resident number format : 000000[0~4]000000
            //                      Index=6->^         ^
            //                               -backDigit-
            this.password = residentNumber.substring(6,residentNumber.length());
        } else {
            throw new Exception("can't make new instance via wrong input format");
        }
    }
 
    //public functional methods
 
    //password 설정
    //기존 비밀번호가 먼저 입력되어야 하며,
    //두번 입력해서, 같은 비밀번호일 시 비밀번호 변경
    public void changePassword() {
        //비밀번호 조건 : 알파벳, 숫자 7자리 문자열
        final String passwordPattern = "^[a-zA-Z0-9]{7}$";
 
        System.out.println("===============================");
        System.out.print("현재 비밀번호를 입력하세요. : ");
        if(!this.password.equals(getConsoleInput())){
            System.out.println("===============================");
            System.out.println("비밀번호가 틀립니다.");
            return;
        }
 
        for(int i=0;i<5;i++){
            System.out.print("변경할 비밀번호를 입력하세요. : ");
            String input = getConsoleInput();
 
            if(!Pattern.matches(passwordPattern, input)){
                System.out.println("===============================");
                System.out.println("잘못된 비밀번호입니다. 비밀번호는 반드시 7자리의 영문자 및 숫자로 구성되야 합니다.");
                continue;
            }else{
                
                System.out.print("다시 한번 입력하세요. : ");
                if(input.equals(getConsoleInput())){
                    password = input;
                    System.out.println("===============================");
                    System.out.println("비밀번호 변경이 완료되었습니다.");
                    return;
                }else{
                    System.out.println("===============================");
                    System.out.println("입력된 비밀번호가 일치하지 않습니다.");
                    continue;
                }
            }
        }
        System.out.println("===============================");
        System.out.println("5회 실패하셨습니다. 다시 시도해주세요.");
        return;
    }
 
    //이 메소드에서 강의 정보들을 입력 받아서, Lecture 클래스를 생성한다.
    //생성한 Lecture 객체는 매개변수로 입력받은 courseArray에 추가한다.
    public void addCourse(ArrayList<Lecture> courseArray, ArrayList<Professor> professorArray){
        //각 변수들에 필요한 조건
        final String courseNumPattern = "^[0-9]+$";
        final String courseCreditPattern = "^[0-9]{1}$";
        final String courseMinMaxPattern = "^[0-9]+(~)[0-9]+$";
        final String courseTuitionPattern = "^[0-9]+$";
        
        System.out.println("===============================");
        System.out.println("강좌 개설을 위해서는 강좌번호, 이름, 학과, 학점, 설명, 담당 교수, 최소, 최대 학생수 입력이 필요합니다.");
        System.out.println("===============================");
        int switchPtr=0;
        int count=0;
        String courseNum="", courseName="", courseDepart="", courseCredit="",
                courseExplain="", courseMin="", courseMax="", courseTuition="";
        Professor courseProfessor=null;
        while(count<=3){
            switch(switchPtr){
                case 0:
                    System.out.print("강좌 번호를 숫자로 입력해주세요(예시 : 100183). : ");
                    courseNum = getConsoleInput();
                    if(!Pattern.matches(courseNumPattern,courseNum)){
                        System.out.println("숫자만 입력 가능합니다.");
                        count++;
                    }else{
                        int finalNum = Integer.parseInt(courseNum);
                        if(courseArray.stream().
                                filter(e->e.getLectNum().equals(Integer.toString(finalNum))).findFirst().orElse(null)!=null){
                            System.out.println("강의 번호가 이미 존재합니다.");
                            count++;
                        }else{
                        switchPtr++;}}
                    break;
 
                case 1:
                    System.out.print("강좌 이름을 입력해주세요(예시 : 객체지향프로그래밍II). : ");
                    courseName = getConsoleInput();
                    switchPtr++;
                    break;
 
                case 2:
                    System.out.print("강좌 학과를 입력해주세요(예시 : 컴퓨터소프트웨어공학과). : ");
                    courseDepart = getConsoleInput();
                    switchPtr++;
                    break;
 
                case 3:
                    System.out.print("강좌 학점을 한 자리 정수로 입력해주세요. : ");
                    courseCredit = getConsoleInput();
                    if(!Pattern.matches(courseCreditPattern,courseCredit)){
                        System.out.println("숫자만 입력 가능합니다.");
                        count++;
                    }else{
                        switchPtr++;}
                    break;
 
                case 4:
                    System.out.print("강좌의 설명을 간략하게 입력해주세요. : ");
                    courseExplain = getConsoleInput();
                    switchPtr++;
                    break;
 
                case 5:
                    System.out.print("강좌 담당 교수 이름을 입력해 주세요. : ");
                    String input;
                    input = getConsoleInput();
                    String finalInput = input;
 
                    ArrayList<Professor> search = new ArrayList<Professor> (Arrays.asList(professorArray.stream().
                            filter(e->e.getProfName().equals(finalInput)).toArray(Professor[]::new)));
 
                    if(search.size()==0){
                        System.out.println("존재하지 않는 교수입니다.");
                        count++;
                    }else if((search.size()>=2)){
                        System.out.println("동명의 교수가 존재합니다.");
                        System.out.println("다음 교수 중 하나를 선택하시기 바랍니다.");
                        System.out.printf("%-12s|%-16s|%-40s\n", "교수번호", "이름", "학과");
                        search.forEach(
                                e->System.out.printf("%-12s|%-16s|%-40s\n",e.getPnum(),e.getProfName(),e.getMajor()));
 
                        while(true) {
                            System.out.print("교수 번호를 입력하세요 : ");
                            input = getConsoleInput();
 
                            String searchNum = input;
                            courseProfessor = search.stream().findFirst().orElse(null);
 
                            if(!courseProfessor.equals("-1"))
                                break;
                            else{
                                System.out.println("리스트에 존재하는 교수만 선택 가능합니다.");
                            }
                        }
                        switchPtr++;
                    }else{
                        courseProfessor = search.stream().findFirst().orElse(null);
 
                        switchPtr++;
                    }
                    break;
                    
                case 6:
                    System.out.print("강의 수강료를 입력해주세요. : ");
                    courseTuition = getConsoleInput();
                    if(!Pattern.matches(courseTuitionPattern,courseTuition)){
                        System.out.println("숫자만 입력 가능합니다.");
                        count++;
                    }else{
                        switchPtr++;
                    }
                    break;
 
                case 7:
                    System.out.print("촤소/최대 수강 인원을 '~'로 구분해서 입력해주세요(예시 : 16~33). : ");
                    String studentRangeInput = getConsoleInput();
                    if(!Pattern.matches(courseMinMaxPattern,studentRangeInput)){
                        System.out.println("잘못된 입력입니다. 입력을 확인하세요");
                        count++;
                    }else{
                        StringTokenizer token = new StringTokenizer(studentRangeInput, "~");
                        courseMin = token.nextToken();
                        courseMax = token.nextToken();
 
                        //int courseNum, String name, int credit, String department, String explanation,
                        //int professor, int minimum, int maximum
                        
                        //public Lecture(String LectName, String Major, String Introduction, String LectNum, int Credit, int Min, int Max, double Tuition, Professor professor)
                        
                        courseArray.add(new Lecture(courseName, courseDepart, courseExplain, courseNum, Integer.parseInt(courseCredit), 
                                Integer.parseInt(courseMin), Integer.parseInt(courseMax), 
                                Double.parseDouble(courseTuition), courseProfessor));
                        return;
                    }
                    break;
            }
        }
        System.out.println("3번 이상 잘못된 입력이 감지되었습니다. 다시 시도해주세요.");
    }
 
    public void removeCourse(ArrayList<Lecture> courseArray){
        final String courseNumPattern = "^[0-9]+$";
        System.out.println("===============================");
        System.out.print("삭제를 원하는 강좌의 강좌 번호를 입력해주세요 : ");
        String input = getConsoleInput();
        System.out.println("===============================");
        if(!Pattern.matches(courseNumPattern,input)){
            System.out.println("숫자만 입력 가능합니다.");
            return;
        }
 
 
        Lecture target = courseArray.stream().filter(e->e.getLectNum().equals(input)).
                findFirst().orElse(null);
        if(target==null){
            System.out.println("존재하지 않는 강의입니다.");
            return;
        }
 
        if(!target.isCheck()){
            courseArray.remove(courseArray.indexOf(target));
            System.out.println("강의 "+target.getLectName()+" 이(가) 삭제되었습니다.");
        }else{
            System.out.println("이미 강의가 개설된 강좌입니다.");
            System.out.println("강의가 개설된 강좌는 삭제할 수 없습니다.");
        }
 
    }
    
    public void editCourse(ArrayList<Lecture> courseArray, ArrayList<Professor> professorArray){
        final String courseNumPattern = "^[0-9]+$";
 
        System.out.print("수정을 원하는 강좌의 강좌 번호를 입력해주세요 : ");
        String input = getConsoleInput();
 
        if(!Pattern.matches(courseNumPattern,input)){
            System.out.println("숫자만 입력 가능합니다.");
            return;
        }
 
        String finalInput = input;
        Lecture target = courseArray.stream().filter(e->e.getLectNum().equals(finalInput)).
                findFirst().orElse(null);
        if(target==null){
            System.out.println("존재하지 않는 강의입니다.");
            return;
        }
        if(target.isCheck()){
            System.out.println("이미 강의가 개설된 강좌입니다.");
            System.out.println("강의가 개설된 강좌는 삭제할 수 없습니다.");
            return;
        }
        System.out.println("선택한 강의의 내용은 다음과 같습니다. 수정할 데이터를 입력해주세요");
        System.out.print("강의 이름 : " + target.getLectName() + " -> ");
        target.setLectName(getConsoleInput());
        System.out.print("강의 담당 교수 : " + target.getProfname() + " (교수 이름 입력)-> ");
        
        Professor professor = null;
        String profNameInput = getConsoleInput();
        
        ArrayList<Professor> search = new ArrayList<Professor> (Arrays.asList(professorArray.stream().
                            filter(e->e.getProfName().equals(profNameInput)).toArray(Professor[]::new)));
 
        if(search.size()==0){
            System.out.println("존재하지 않는 교수입니다.");
        }else if((search.size()>=2)){
            System.out.println("동명의 교수가 존재합니다.");
            System.out.println("다음 교수 중 하나를 선택하시기 바랍니다.");
            System.out.printf("%-12s|%-16s|%-40s\n", "교수번호", "이름", "학과");
            search.forEach(e->System.out.printf("%-12s|%-16s|%-40s\n",e.getPnum(),e.getProfName(),e.getMajor()));
 
                while(true) {
                    System.out.print("교수 번호를 입력하세요 : ");
                    input = getConsoleInput();
 
                    String searchNum = input;
                    professor = search.stream().findFirst().orElse(null);
 
                    if(professor!=null)
                        break;
                    else{
                        System.out.println("리스트에 존재하는 교수만 선택 가능합니다.");}
                }
        }else{
            professor = search.stream().findFirst().orElse(null);
        }
        
        target.setProfessor(professor);
        try{
            System.out.print("학점 : " + target.getCredit() + " -> ");
            target.setCredit(Integer.parseInt(getConsoleInput()));
        }catch(NumberFormatException e){
            System.out.println("숫자만 입력 가능합니다.");
        }
        try{
            System.out.print("수강료 : " + target.getTuition());
            target.setTuition(Double.parseDouble(getConsoleInput()));
        }catch(NumberFormatException e){
            System.out.println("숫자만 입력 가능합니다.");
        }
    }
 
    //청구서를 출력하는 메소드.
    public void printBill(ArrayList<Lecture> courseArray, ArrayList<Student> studentArray){
        final String courseNumPattern = "^[0-9]+$";
        System.out.println("===============================");
        System.out.print("청구서 출력을 원하는 강좌의 강좌 번호를 입력해주세요 : ");
        String input = getConsoleInput();
        System.out.println("===============================");
        
        if(!Pattern.matches(courseNumPattern,input)){
            System.out.println("숫자만 입력 가능합니다.");
            return;
        }
 
 
        Lecture target = courseArray.stream().filter(e->e.getLectNum().equals(input)).
                findFirst().orElse(null);
 
        if(target==null){
            System.out.println("존재하지 않는 강의입니다.");
        }
        else{
        System.out.println("청구서를 각 학생에게 전송 중입니다...");
        }
        
        try{
            for(Student student:target.getRegisteredStudentArray()){
                //해당 코드는 Student 담당과 합의 하에, 작성할 것
                student.addBill(target.getLectNum(), target.getTuition());
 
            }
        }
 
        catch(NullPointerException e){
            System.out.println("===============================");
            System.out.println("에러가 발생했습니다.");
            System.out.println("아마도 이미 학생이 존재하지 않을 수 있습니다. 출석부를 확인하시기 바랍니다.");
        }
 
    }
 
    public void setLecturesCheck(ArrayList<Lecture> lecturesArray){
        System.out.print("강의 개설로 설정할 강좌의 번호를 입력하세요 : ");
        String input1 = getConsoleInput();
        
        Lecture selectedLecture = lecturesArray.stream().filter(
                e->e.getLectNum().equals(input1)).findFirst().orElse(null);
        
        if(selectedLecture==null){
            System.out.println("존재하지 않는 강의입니다.");
            return;
        }
        System.out.print("강의를 개설 상태로 지정하시겠습니까? 취소할 경우, 학기 개설 상태는 개설 안 됨으로 지정됩니다.(Y/N) : ");
        String input2 = getConsoleInput();
        if(input2.equals("Y")){
            selectedLecture.setCheck(true);
            selectedLecture.setSemesterCheck(true);
            System.out.println("설정을 완료했습니다.");
        }else{
            selectedLecture.setSemesterCheck(false);
            System.out.println("설정을 완료했습니다.");
        }
    }
    
    
    public boolean tryLogin(String passwordInput){
        return passwordInput.equals(password);
    }
    //Getter/Setter/underground running methods
    public String getIdNumber() {
        return idNumber;
    }
    
      public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    private String getConsoleInput(){
        try{
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
 
            return inputStream.readLine();
        }
        catch(IOException e){
            System.out.println("입력 중 오류가 발생했습니다.");
            System.out.println("동일한 오류 발생시, 관리자에게 문의하시기 바랍니다.");
            System.out.println("Error : " + e);
            return null;
        }
    }
 
    //Override methods for Java basic APIs
//    @Override
//    public boolean equals(Object object){
//        String sample = (String) object;
//
//        if(sample.compareTo(this.idNumber)==0){
//            return true;
//        }else{
//            return false;
//        }
//    }
 
    @Override
    public String toString(){
        return this.idNumber;
    }
 
 
}