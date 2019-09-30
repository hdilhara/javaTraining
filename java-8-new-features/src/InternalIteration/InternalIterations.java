package InternalIteration;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class InternalIterations {


    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,20,35,4,5);
        //list.forEach(i-> System.out.println(i));

//        Consumer<Integer> c=new Consumer<Integer>() {//annonymous class
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        };
//
//        list.forEach(c);

//        list.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

//        List<Integer> listA=Arrays.asList(1,2,3,4,5);
//        listA.forEach((Integer i)-> {System.out.println(i);
//            System.out.println(i);});

        Consumer<Integer> c=i-> System.out.println(i);
        List<Integer> list1=Arrays.asList(1,2,3555,4,5);
        list1.forEach(c);

    }
}
