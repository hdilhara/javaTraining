package diamondProblemInInterface;


public class NotDiamond implements A ,B{
    public static void main(String[] args) {
        NotDiamond main=new NotDiamond();
        main.show();
        main.how();
    }
}


interface A{
    default void show(){
        System.out.println("This is Interface A");
    }
}

interface B{
    default void how(){
        System.out.println("This is Interface B");
    }
}