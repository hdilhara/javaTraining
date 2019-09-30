package MethodReference;

public class ReferenceConstructor {

    public ReferenceConstructor(String msg) {
        System.out.println("This is msg "+msg);
    }

    public static void main(String[] args) {
        //ReferenceConstructor referenceConstructor=new ReferenceConstructor("This is msg!");
        FIR fir=ReferenceConstructor::new;
        fir.say("thilina");

    }
}

@FunctionalInterface
interface FIR{
    void say(String msg);
}
