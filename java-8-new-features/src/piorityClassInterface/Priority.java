package piorityClassInterface;

public class Priority extends PrirityClass implements PriorityI {
    public static void main(String[] args) {
        Priority priority=new Priority();
        priority.show();
    }
}

interface PriorityI{
    default void show(){
        System.out.println("This is PriorityI");
    }
}
class PrirityClass{
    public void show(){
        System.out.println("This is PriorityClass");
    }
}