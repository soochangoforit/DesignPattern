package BuilderPattern;


public class ComputerBuilder {
    
    private  Computer computer;
    
    private ComputerBuilder(){
        computer = new Computer("","","256 ssd");
    }
    
    public static ComputerBuilder start(){
        return new ComputerBuilder();
    }
    
    public ComputerBuilder setCpu(String cpu){
        computer.setCpu(cpu);
        return this;
    }
    
     public ComputerBuilder setRam(String ram){
        computer.setRam(ram);
        return this;
    }
     
     public ComputerBuilder setStorage(String storage){
        computer.setStorage(storage);
        return this;
    }
    
     
     
     
    public Computer build(){
        return this.computer;
    }
    
}
