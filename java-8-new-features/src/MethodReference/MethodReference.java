package MethodReference;

public class MethodReference {

    public void sayble(){
        System.out.println("this is sayble method");
    }

    public static void main(String[] args) {

        MethodReference methodReference=new MethodReference();

        //FunInterface funInterface=()-> System.out.println("this is lamda expressions!");
        FunInterface funInterface=methodReference::sayble;
        funInterface.say();

    }
}

@FunctionalInterface
interface FunInterface{
    void say();
}