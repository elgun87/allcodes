package RandomPractice;

public class Apple {
    String color;
    public Apple(){
        super();
        System.out.println("I am Apple contsructor no args");
    }
    public Apple(String color){
        this.color = color;
        System.out.println("I am Apple constructor with args");
    }
}
