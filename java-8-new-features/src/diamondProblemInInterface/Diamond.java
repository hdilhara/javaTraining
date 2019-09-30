package diamondProblemInInterface;

public class Diamond implements A1,B1{
    public void show(){
        System.out.println("This is Class Diamond");
    }

    public static void main(String[] args) {
        Diamond diamond=new Diamond();
        diamond.show();
    }
}

interface A1{
    default void show(){
        System.out.println("This is I A1");
    }
}

interface B1{
    default void show(){
        System.out.println("This is I B1");
    }
}