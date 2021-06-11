package GurhanTask.Day8;

import com.github.javafaker.Faker;

import java.util.Properties;

public class Test {
    static int pizza;
    static double wallet;

    {
        pizza = 12;
        wallet = 25.99;
    }

   public void eat(int num){
       pizza -= num;
       System.out.println(pizza);
   }

   public static void payMe(){
       wallet -= 5.99;
   }

    public static void main(String[] args) {
        Test father = new Test();
        father.eat(2);
//
//
//        Test mother = new Test();
//        mother.eat(3);
//
//
//        Test child = new Test();
//        child.eat(4);
//        Test.payMe();
//        System.out.println(Test.wallet);
    }

}
