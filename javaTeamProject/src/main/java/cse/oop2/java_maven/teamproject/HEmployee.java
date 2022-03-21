package cse.oop2.java_maven.teamproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HEmployee {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));;   
    private int inputNum;
    private String name;      //직원개인정보
    private String number;
    private String residentnumber;
    private String pw;
    private static final int NUM_LEN=4;

    public HEmployee(String name, String number, String residentnumber) {
        
        
        this.name = name;
        this.number = number;
        this.residentnumber = residentnumber;
        this.pw = residentnumber.substring(residentnumber.length()-7, residentnumber.length());
    }
    
    public void setInputNum() throws IOException {
        this.inputNum=Integer.parseInt(in.readLine());
    }
    public int getInputNum() {
        return this.inputNum;
    }
    public String getPw() {
        return pw;
    }
    public void setNumber(String number) {
        this.number=number;
    }
    public String getNumber() {
        return number;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setRSnum(String residentnumber) {
        this.residentnumber=residentnumber;
    }
    public String getRSnum() {
        return residentnumber;
    }

    public void addUser(){
        try{
        System.out.println("===============================");
        System.out.println("추가하고 싶은 사용자 유형을 선택하세요. ");
        System.out.println("1. 학생 2. 교수 3. 학사직원 4.수강담당직원 ");
        System.out.println("===============================");
        int input = Integer.parseInt(in.readLine());
        
        switch(input){
            case 1:
                addStudent();
                break;
            case 2:
                addProfessor();
                break;
            case 3:
                addHEmployee();
                break;
            case 4:
                addGEmployee();
                break;
                
            default:
                System.out.println("메뉴 내의 범위에서 선택해 주세요.");
                break;
        }}catch(IOException e){
            System.out.println("입력 중 에러가 발생했습니다.");
        }
    }
    
    public void addStudent() {     //학생  
        try {
            System.out.println("===============================");
            System.out.print("이름 : ");
            String name1 = in.readLine();
            System.out.print("학번 : ");
            String number1 = in.readLine();
            System.out.print("학과 : ");
            String major1 = in.readLine();
            System.out.print("주민등록번호 : ");
            String residentnumber1 = in.readLine();
            
            for(Student index : TestDrive.studentsArray){
                if(index.getStuId().equals(number1)){
                    System.out.println("이미 등록된 학생입니다.");
                    return;
                }
            }
            TestDrive.studentsArray.add(new Student("S"+number1, name1, major1, residentnumber1));
            System.out.println("사용자 등록이 완료되었습니다.");
        }catch(Exception e) {
            System.out.println("입력이 틀렸습니다.");
        }  
    }
    
    public void addProfessor () {      //교수
        try {
            System.out.println("===============================");
            System.out.print("이름 : ");
            String name1 = in.readLine();
            System.out.print("교수번호 : ");
            String number1 = in.readLine();
            System.out.print("학과 : ");
            String major1 = in.readLine();
            System.out.print("주민등록번호 : ");
            String residentnumber1 = in.readLine();
            
            for(Professor index : TestDrive.professorsArray){
                if(index.getPnum().equals(number1)){
                    System.out.println("이미 등록된 교수입니다.");
                    return;
                }
            }
            TestDrive.professorsArray.add(new Professor("P"+number1, residentnumber1, name1, major1));  
            System.out.println("사용자 등록이 완료되었습니다.");
        }catch(Exception e) {
            System.out.println("입력이 틀렸습니다.");
        }
    }

    public void addHEmployee() {     //학사관리직원
        try {
            System.out.println("===============================");
            System.out.print("이름 : ");
            String name1 = in.readLine();
            System.out.print("직원번호 : ");
            String number1 = in.readLine();
            System.out.print("주민등록번호 : ");
            String residentnumber1 = in.readLine();
            
            for(HEmployee index : TestDrive.hEmployeesArray){
                if(index.getNumber().equals(number1)){
                    System.out.println("이미 등록된 학번입니다.");
                    return;
                }
            }
            TestDrive.hEmployeesArray.add(new HEmployee(name1, "H"+number1, residentnumber1));  
            System.out.println("사용자 등록이 완료되었습니다.");
        }catch(Exception e) {
            System.out.println("입력이 틀렸습니다.");
        }
    }
   
    public void addGEmployee() {     //수업관리직원
        try {
            System.out.println("===============================");
            System.out.print("이름 : ");
            String name1 = in.readLine();
            System.out.print("직원번호 : ");
            String number1 = in.readLine();
            System.out.print("주민등록번호 : ");
            String residentnumber1 = in.readLine();
            
            for(GEmployee index : TestDrive.gEmployeesArray){
                if(index.getGnumber().equals(number1)){
                    System.out.println("이미 등록된 학번입니다.");
                    return;
                }
            }
            TestDrive.gEmployeesArray.add(new GEmployee("G"+number1, name1, residentnumber1));     
            System.out.println("사용자 등록이 완료되었습니다.");
        }catch(Exception e) {
            System.out.println("입력이 틀렸습니다.");
        }
    }

    //정보 변경
    public void reviseUser(){
        try{
        System.out.println("===============================");    
        System.out.println("수정하고 싶은 사용자 유형을 선택하세요. ");
        System.out.println("1.학생 2.교수 3.학사직원 4.수강담당직원");
        System.out.println("===============================");
        int input = Integer.parseInt(in.readLine());
        
        switch(input){
            case 1:
                reviseStudent();
                break;
            case 2:
                reviseProfessor();
                break;
            case 3:
                reviseHEmployee();
                break;
            case 4:
                reviseGEmployee();
                break;
                
            default:
                System.out.println("메뉴 내의 범위에서 선택해 주세요.");
                break;
        }}catch(IOException e){
            System.out.println("입력 중 에러가 발생했습니다.");
        }
    }

    public void reviseStudent() {      //학생
        int i = 1;

        try {
            if(TestDrive.studentsArray.size() != 0) {
                System.out.println("===============================");
                for(Student index : TestDrive.studentsArray){
                    System.out.println(i + ". 이름 : " + index.getStuName() + " 학번 : " + index.getStuId() + " 학과 : " + index.getMajor() + " 주민등록번호 : " + index.getStuRNum());
                    i++;
                }
                System.out.println("===============================");
                System.out.print("변경할 학생을 선택하십시오 : ");
                int n = Integer.parseInt(in.readLine());
                System.out.println("===============================");
                System.out.print("1.이름   2.학번   3.학과   4.주민등록번호");
                System.out.print("입력 : ");
                i=Integer.parseInt(in.readLine());
                System.out.println("===============================");
                switch(i) {
                    case 1:
                        System.out.print("변경할 이름 : ");
                        String name1 = in.readLine();
                        
                        TestDrive.studentsArray.get(n-1).setStuName(name1);
                        break;
                    case 2:
                       System.out.print("변경할 학번 : ");
                        String num1 = in.readLine();
                        
                        TestDrive.studentsArray.get(n-1).setStuId(num1);
                        break;                    
                    case 3:
                        System.out.print("변경할 학과 : ");
                        String major1 = in.readLine();
                        
                        TestDrive.studentsArray.get(n-1).setMajor(major1);
                        break;
                    case 4:
                        System.out.print("변경할 주민등록번호 : ");
                        String r_num1 = in.readLine();
                        
                        TestDrive.studentsArray.get(n-1).setStuRNum(r_num1);
                        break;                        
                }
                System.out.println("===============================");
                System.out.println("변경되었습니다.");
            }
            else {
                System.out.println("등록된 학생이 없습니다.");
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    public void reviseProfessor() {      //교수
        int i = 1;

        try {
            if(TestDrive.professorsArray.size() != 0) {
                System.out.println("===============================");
                for(Professor index : TestDrive.professorsArray){
                    System.out.println(i + ". 이름 : " + index.getProfName() + " 학번 : " + index.getPnum() + " 학과 : " + index.getMajor() + " 주민등록번호 : " + index.RSnum());
                    i++;
                }
                System.out.println("===============================");
                System.out.print("변경할 교수를 선택하십시오 : ");
                int n = Integer.parseInt(in.readLine());
            
                System.out.println("===============================");
                System.out.print("1.이름   2.교수번호   3.학과   4.주민등록번호");
                System.out.print("입력 : ");
                System.out.println("===============================");
                i=Integer.parseInt(in.readLine());
                
                switch(i) {
                    case 1:
                        System.out.print("변경할 이름 : ");
                        String name1 = in.readLine();
                        
                        TestDrive.professorsArray.get(n-1).setProfName(name1);
                        break;
                    case 2:
                       System.out.print("변경할 교수번호 : ");
                        String num1 = in.readLine();
                        
                        TestDrive.professorsArray.get(n-1).setPnum(num1);
                        break;                    
                    case 3:
                        System.out.print("변경할 학과 : ");
                        String major1 = in.readLine();
                        
                        TestDrive.professorsArray.get(n-1).setMajor(major1);
                        break;
                    case 4:
                        System.out.print("변경할 주민등록번호 : ");
                        String r_num1 = in.readLine();
                        
                        TestDrive.professorsArray.get(n-1).setRSnum(r_num1);
                        break;                        
                }
                System.out.println("===============================");
                System.out.println("변경되었습니다.");
            }
            else {
                System.out.println("등록된 교수가 없습니다.");
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }
    
    public void reviseHEmployee() {      //학사관리직원
        int i = 1;
    
        try {
            if(TestDrive.hEmployeesArray.size() != 0) {
                System.out.println("===============================");
                for(HEmployee index : TestDrive.hEmployeesArray){
                    System.out.println(i + ". 이름 : " + index.getName() + " 직원번호 : " + index.getNumber() + " 주민등록번호 : " + index.getRSnum());
                    i++;
                }
                System.out.println("===============================");
                System.out.print("변경할 직원번호를 선택하십시오 : ");
                int n = Integer.parseInt(in.readLine());
            
                System.out.println("===============================");
                System.out.print("1.이름   2.직원번호   3.주민등록번호");
                System.out.print("입력 : ");
                i=Integer.parseInt(in.readLine());
                System.out.println("===============================");
                switch(i) {
                    case 1:
                        System.out.print("변경할 이름 : ");
                        String name1 = in.readLine();
                        
                        TestDrive.hEmployeesArray.get(n-1).setName(name1);
                        break;
                    case 2:
                       System.out.print("변경할 직원번호 : ");
                        String num1 = in.readLine();
                        
                        TestDrive.hEmployeesArray.get(n-1).setNumber(num1);
                        break;                    
                    case 3:
                        System.out.print("변경할 주민등록번호 : ");
                        String r_num1 = in.readLine();
                        
                        TestDrive.hEmployeesArray.get(n-1).setRSnum(r_num1);
                        break;                                        
                }
                System.out.println("===============================");
                System.out.println("변경되었습니다.");
            }
            else {
                System.out.println("등록된 학사관리직원이 없습니다.");
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    public void reviseGEmployee() {      //수업관리직원
        int i = 1;
    
        try {
            if(TestDrive.gEmployeesArray.size() != 0) {
                System.out.println("===============================");
                for(GEmployee index : TestDrive.gEmployeesArray){
                    System.out.println(i + ". 이름 : " + index.getGname() + " 직원번호 : " + index.getIdNumber() + " 주민등록번호 : " + index.getGRnumber());
                    i++;
                }
                System.out.println("===============================");
                System.out.print("변경할 직원번호를 선택하십시오 : ");
                int n = Integer.parseInt(in.readLine());
            
                System.out.println("===============================");
                System.out.print("1.이름   2.직원번호   3.주민등록번호");
                System.out.print("입력 : ");
                i=Integer.parseInt(in.readLine());
                
                switch(i) {
                    case 1:
                        System.out.print("변경할 이름 : ");
                        String name1 = in.readLine();
                        
                        TestDrive.gEmployeesArray.get(n-1).setGname(name1);
                        break;
                    case 2:
                       System.out.print("변경할 직원번호 : ");
                        String num1 = in.readLine();
                        
                        TestDrive.gEmployeesArray.get(n-1).setGnumber(num1);
                        break;                    
                    case 3:
                        System.out.print("변경할 주민등록번호 : ");
                        String r_num1 = in.readLine();
                        
                        TestDrive.gEmployeesArray.get(n-1).setGRnumber(r_num1);
                        break;                                        
                }
                System.out.println("===============================");
                System.out.println("변경되었습니다.");
            }
            else {
                System.out.println("등록된 수업담당자가 없습니다.");
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    
    //조회
    public void checkUser(){
        try{
        System.out.println("===============================");
        System.out.println("검색하고 싶은 사용자 유형을 선택하세요. ");
        System.out.println("1.학생 2.교수 3.학사직원 4.수강담당직원");
        System.out.println("===============================");
        int input = Integer.parseInt(in.readLine());
        System.out.println("===============================");
        switch(input){
            case 1:
                checkStudent();
                break;
            case 2:
                checkProfessor();
                break;
            case 3:
                checkHEmployee();
                break;
            case 4:
                checkGEmployee();
                break;
                
            default:
                System.out.println("메뉴 내의 범위에서 선택해 주세요.");
                break;
        }}catch(IOException e){
            System.out.println("입력 중 에러가 발생했습니다.");
        }
    }
    
    public void checkStudent(){      //학생
        try {
            System.out.println("1.학번   2.이름");
            System.out.println("===============================");
            int num = Integer.parseInt(in.readLine());
            System.out.println("===============================");
            String n;
            switch(num) {
                case 1:
                    System.out.print("검색하실 학번을 입력해주세요 : ");
                    n = in.readLine();
                    System.out.println("===============================");
                    
                    for(Student index: TestDrive.studentsArray) {
                        if(index.getStuId().equals(n)){
                            System.out.println("이름 : " + index.getStuName() + " 학번 : " + index.getStuId() + " 학과 : " + index.getMajor() + " 주민등록번호 : " + index.getStuRNum());
                        }
                    }
                    break;
                case 2:
                    System.out.print("검색하실 이름을 입력해주세요 : ");
                    n = in.readLine();
                    System.out.println("===============================");
                    
                    for(Student index: TestDrive.studentsArray) {
                        if(index.getStuName().equals(n)){
                            System.out.println("이름 : " + index.getStuName() + " 학번 : " + index.getStuId() + " 학과 : " + index.getMajor() + " 주민등록번호 : " + index.getStuRNum());
                        }
                    }
                    break;
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    public void checkProfessor() {        //교수
        try {
            System.out.println("1.교수번호   2. 이름");
            System.out.println("===============================");
            int num = Integer.parseInt(in.readLine());
            System.out.println("===============================");
            String n;
        
            switch(num) {
                case 1:
                    System.out.print("검색하실 교수번호를 입력해주세요 : ");
                    n = in.readLine();
                    System.out.println("===============================");
                    
                    for(Professor index: TestDrive.professorsArray) {
                        if(index.getPnum().equals(n)){
                            System.out.println("이름 : " + index.getProfName() + " 교수번호 : " + index.getPnum() + " 학과 : " + index.getMajor() + " 주민등록번호 : " + index.RSnum());
                        }
                    }
                    break;
                case 2:
                    System.out.print("검색하실 이름을 입력해주세요 : ");
                    n = in.readLine();
                    System.out.println("===============================");
                    
                    for(Professor index: TestDrive.professorsArray) {
                        if(index.getProfName().equals(n)){
                            System.out.println("이름 : " + index.getProfName() + " 교수번호 : " + index.getPnum() + " 학과 : " + index.getMajor() + " 주민등록번호 : " + index.RSnum());
                        }
                    }     
                    break;
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    public void checkHEmployee() {      //학사관리직원
        try {
            System.out.println("1.직원번호   2. 이름");
            System.out.println("===============================");
            int num = Integer.parseInt(in.readLine());
            System.out.println("===============================");
            String n;
            switch(num) {
                case 1:
                    System.out.print("검색하실 직원번호를 입력해주세요 : ");
                    n = in.readLine();
                    System.out.println("===============================");
                    
                    for(HEmployee index: TestDrive.hEmployeesArray) {
                        if(index.getNumber().equals(n)){
                            System.out.println("이름 : " + index.getName() + " 직원번호 : " + index.getNumber() + " 주민등록번호 : " + index.getRSnum());
                        }
                    }
                    break;
                case 2:
                    System.out.print("검색하실 이름을 입력해주세요 : ");
                    n = in.readLine();
                    System.out.println("===============================");
                    
                    for(HEmployee index: TestDrive.hEmployeesArray) {
                        if(index.getName().equals(n)){
                            System.out.println("이름 : " + index.getName() + " 직원번호 : " + index.getNumber() + " 주민등록번호 : " + index.getRSnum());
                        }
                    }     
                    break;
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    public void checkGEmployee() {      //수업관리직원
        try {
            System.out.println("1.직원번호   2. 이름");
            System.out.println("===============================");
            int num = Integer.parseInt(in.readLine());
            System.out.println("===============================");
            String n;
        
            switch(num) {
                case 1:
                    System.out.print("검색하실 직원번호를 입력해주세요 : ");
                    n = in.readLine();
                    System.out.println("===============================");
                    
                    for(GEmployee index: TestDrive.gEmployeesArray) {
                        if(index.getGnumber().equals(n)){
                            System.out.println("이름 : " + index.getName() + " 직원번호 : " + index.getGnumber() + " 주민등록번호 : " + index.getGRnumber());
                        }
                    }
                    break;
                case 2:
                    System.out.print("검색하실 이름을 입력해주세요 : ");
                    n = in.readLine();
                    System.out.println("===============================");
                    
                    for(GEmployee index: TestDrive.gEmployeesArray) {
                        if(index.getGname().equals(n)){
                            System.out.println("이름 : " + index.getName() + " 직원번호 : " + index.getGnumber() + " 주민등록번호 : " + index.getGRnumber());
                        }
                    }     
                    break;
            } 
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    
    //삭제  
    public void deleteUser(){
        try{
        System.out.println("===============================");
        System.out.println("삭제하고 싶은 사용자 유형을 선택하세요. ");
        System.out.println("1.학생 2.교수 3.학사직원 4.수강담당직원");
        System.out.println("===============================");
        int input = Integer.parseInt(in.readLine());
        System.out.println("===============================");
        
        switch(input){
            case 1:
                deleteStudent();
                break;
            case 2:
                deleteProfessor();
                break;
            case 3:
                deleteHEmployee();
                break;
            case 4:
                deleteGEmployee();
                break;
                
            default:
                System.out.println("메뉴 내의 범위에서 선택해 주세요.");
                break;
        }}catch(IOException e){
            System.out.println("입력 중 에러가 발생했습니다.");
        }
    }
    
    public void deleteStudent() {      //학생
        int i =1;
        
        try {
            if(TestDrive.studentsArray.size() != 0) {
                for(Student index : TestDrive.studentsArray){
                    System.out.println(i + ". 이름 : " + index.getStuName() + " 학번 : " + index.getStuId() + " 학과 : " + index.getMajor() + " 주민등록번호 : " + index.getStuRNum());
                    i++;
                }
                System.out.println("===============================");
                System.out.print("삭제할 학생을 선택하십시오: ");
                int n = Integer.parseInt(in.readLine());
                System.out.println("===============================");
                TestDrive.studentsArray.remove(n-1);
                System.out.println("삭제되었습니다.");
            }
            else {
                System.out.println("등록된 학생이 없습니다.");
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    public void deleteProfessor() {        //교수
        int i =1;
        
        try {
            if(TestDrive.professorsArray.size() != 0) {
                for(Professor index : TestDrive.professorsArray){
                    System.out.println(i + ". 이름 : " + index.getProfName() + " 교수번호 : " + index.getPnum() + " 학과 : " + index.getMajor() + " 주민등록번호 : " + index.RSnum());
                    i++;
                }
                System.out.println("===============================");
                System.out.print("삭제할 교수를 선택하십시오 : ");
                int n = Integer.parseInt(in.readLine());
                System.out.println("===============================");
                TestDrive.professorsArray.remove(n-1);
                System.out.println("삭제되었습니다.");
            }
            else {
                System.out.println("등록된 교수가 없습니다.");
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    public void deleteHEmployee() {      //학사관리직원
        int i =1;
        
        try {
            if(TestDrive.hEmployeesArray.size() != 0) {
                for(HEmployee index : TestDrive.hEmployeesArray){
                    System.out.println(i + ". 이름 : " + index.getName() + " 직원번호 : " + index.getNumber() + " 주민등록번호 : " + index.getRSnum());
                    i++;
                }
                System.out.println("===============================");
                System.out.print("삭제할 학사관리직원을 선택하십시오 : ");
                int n = Integer.parseInt(in.readLine());
                System.out.println("===============================");
                TestDrive.hEmployeesArray.remove(n-1);
                System.out.println("삭제되었습니다.");
            }
            else {
                System.out.println("등록된 학사관리직원이 없습니다.");
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }

    public void deleteGEmployee() {      //수업관리직원
        int i =1;
        
        try {
            if(TestDrive.gEmployeesArray.size() != 0) {
                for(GEmployee index : TestDrive.gEmployeesArray){
                    System.out.println(i + ". 이름 : " + index.getGname() + " 직원번호 : " + index.getGnumber() + " 주민등록번호 : " + index.getGRnumber());
                    i++;
                }
                System.out.println("===============================");
                System.out.print("삭제할 수업담당자를 선택하십시오 : ");
                int n = Integer.parseInt(in.readLine());
                System.out.println("===============================");
                
                TestDrive.gEmployeesArray.remove(n-1);
                System.out.println("삭제되었습니다.");
            }
            else {
                System.out.println("등록된 수업담당자가 없습니다.");
            }
        }catch(Exception e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
    }
}