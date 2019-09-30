package staticMethodINterface;

public class StaticMethod {

    public static void main(String[] args) {
        StaticMethodInterface.show();
    }
}

interface StaticMethodInterface{
    public static void show(){
        System.out.println("This is static method in interface");
    }
}
