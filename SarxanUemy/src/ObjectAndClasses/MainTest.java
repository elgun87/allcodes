package ObjectAndClasses;

public class MainTest {
    public static void main(String[] args) {
       User user1 = new User();
       user1.name = "Elgun";

       Student student1 = new Student();
       student1.name = "Mehmet";

       user1.student = student1;
        System.out.println(user1.student.name);
    }
}
