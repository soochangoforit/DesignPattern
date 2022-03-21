package cse.oop2.java_maven.teamproject;

import java.util.ArrayList;

public class Lecture {
 
    private String LectName;        //강의명
    private String Major;           //학과
    private String Introduction;    //강의설명
    private String LectNum;         //강의번호
    private int Credit;             //학점 (학과별 학점을 의미함. ex/전공선택 3학점)
    private int Min, Max;           //최소, 최대 학생수
    private double Tuition;         //수강료
  
    
   
 
    private boolean Check = false;     //개설 여부 (1번이라도 개설되면 TRUE)
    private boolean semesterCheck = false;
    
    private Professor professor;

    public boolean isSemesterCheck() {
        return semesterCheck;
    }

    public void setSemesterCheck(boolean semesterCheck) {
        this.semesterCheck = semesterCheck;
    }
    
    public Professor getProfessor(){
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public String getProfname() {
        return professor.getProfName();
    }

    //수강신청 담당자를 위하 추가했음------------------------------
    private ArrayList<Student> registeredStudentArray = new ArrayList<>(); //하나의 과목에 대해 수강신청한 여러명의 학생 객체를 넣는다.
    private ArrayList<Double> Score = new ArrayList<>();     //인덱스 같이 유지 
    
    public void addScore (){
        this.Score.add(-1.0);
    }
    
    public void setScore(int index, double score){
        this.Score.set(index, score);
    }
    
    public double getScore(Student toGive){
        return Score.get(registeredStudentArray.indexOf(toGive));
    }
    
    public ArrayList<Student> getRegisteredStudentArray() {
        return registeredStudentArray;
    }
    
   public int returnSizeOfCourse() { //내가 곧 신청할랴는 강의에 학생이 몇명이 있는지 반환
        return this.registeredStudentArray.size();
    }
 
   
 
    //매개변수 있는 생성자, 수업담당자가 강의 등록할 때
    public Lecture(String LectName, String Major, String Introduction, String LectNum, int Credit, int Min, int Max, double Tuition, Professor professor) {
        this.LectName = LectName;
        this.Major = Major;
        this.Introduction = Introduction;
        this.LectNum = LectNum;
        this.Credit = Credit;
        this.Min = Min;
        this.Max = Max;
        this.Tuition = Tuition;
        this.professor = professor;
    }
    
    //이하 GET, SET
 
    //강의명
    public String getLectName() {
        return LectName;
    }
    public void setLectName(String LectName) {
        this.LectName = LectName;
    }
 
    //학과
    public String getMajor() {
        return Major;
    }
    public void setMajor(String Major) {
        this.Major = Major;
    }
 
    //강의설명
    public String getIntroduction() {
        return Introduction;
    }
    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }
 
    //강의번호
    public String getLectNum() {
        return LectNum;
    }
    public void setLectNum(String LectNum) {
        this.LectNum = LectNum;
    }
 
    //학점
    public int getCredit() {
        return Credit;
    }
    public void setCredit(int Credit) {
        this.Credit = Credit;
    }
 
    //최소 학생수
    public int getMin() {
        return Min;
    }
    public void setMin(int Min) {
        this.Min = Min;
    }
 
    //최대 학생수
    public int getMax() {
        return Max;
    }
    public void setMax(int Max) {
        this.Max = Max;
    }
 
    //수강료
    public double getTuition() {
        return Tuition;
    }
    public void setTuition(double Tuition) {
        this.Tuition = Tuition;
    }
 
    //강의 개설 여부
    public boolean getCheck() {
        return Check;
    }
    public void setCheck(boolean Check) {
        this.Check = Check;
    }
 
    //강의개설 여부 
    public boolean isCheck() {
        return Check;
    }
}