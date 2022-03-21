
package DeepShalloew;

public class Cat implements Cloneable{
    
    private String name;
    private Age age;

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", age=" + age + '}';
    }
    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // Cloneable를 implements를 하고 clone()을 이요한 copy 구현
    public Cat copy() throws CloneNotSupportedException{
        Cat ret = (Cat) this.clone();
        ret.setAge(new Age(this.age.getYear() , this.age.getValue()));
        
        return ret;
    }
}
