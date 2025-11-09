package day13;

public class InstanceOfTester {

    public static void main(String[] args) {
        Object obj = "Hello, Java 17!";

        if (obj instanceof String str) {  // Direct variable declaration
            System.out.println(str.toUpperCase());
        }

        obj = 42;
        if (obj instanceof Integer num && num > 10) {
            num=num+1;
            System.out.println("Number is greater than 10"+num);
        }
    }
}
