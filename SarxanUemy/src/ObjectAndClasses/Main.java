package ObjectAndClasses;

public class Main {
    public String name;
    public String lastName;
    public static String fullName;

    public Main(){

    }
    private Main(String str,String str2){
        this.name = str;
        this.lastName = str2;
    }
    public static void foo(){
        System.out.println("Hello");
    }

    public void foo2(){
        Main.fullName = "John De";
    }

}
