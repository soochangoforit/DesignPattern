package DeepShalloew;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        
        Cat navi = new Cat();
        navi.setName("navi");
        navi.setAge(new Age(2012,3));
        System.out.println("navi 나이 "+ navi.getAge().getValue()+ " 년도 " + navi.getAge().getYear());
        
        
     
        Cat yo = navi.copy(); 
        yo.setName("yo");
        yo.getAge().setYear(2013);
        yo.getAge().setValue(2);
       
       
        System.out.println(navi.getName());
        System.out.println(yo.getName());
        
        //clone를 한 yo 객체의 필드값이 변하니 navi 객체의 필드값도 함께 변한것을 확인할 수 있다.
        //name에서는 깊은 복사가 이루어졌지만, Age에 대해서는 싶은 복사가 이루어지지 않았다.
        System.out.println("navi year" + navi.getAge().getYear());
        System.out.println("yo year" + yo.getAge().getYear());
        
        System.out.println("navi 나이" + navi.getAge().getValue());
        System.out.println("yo 나이" + yo.getAge().getValue());
        
        // 자바에서 제공하는 String , Integer Class 같은 경우는
        // 깊은 복사를 통해 자동으로 ,주소값을 변경해서 필드를 복사 해준다.
        
        
    }
    
}
