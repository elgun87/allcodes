package RandomPractice;

public class GoldenApple extends Apple {
    public GoldenApple(){
        super("red");
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        GoldenApple apl = new GoldenApple();
        System.out.println(apl.color);
    }
}
