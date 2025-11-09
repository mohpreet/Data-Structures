package day13;
// (JEP 406): Preview  Feature []
public class NewSwitchExample {
    static void process(Integer obj) {
        switch (obj) {
            case 1 -> System.out.println("Integer: " );
            case 2 -> System.out.println("String: " );
            case 3-> System.out.println("Double: ");
            default -> System.out.println("Unknown type!");
        }
    }

    public static void main(String[] args) {
        process(10);         // Integer: 20
    }
}

//https://www.baeldung.com/java-17-new-features