package externalIterations;

import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExternalIteration {

    public static int doubleInt(int i){
        System.out.println(i*2);
        return i*2;
    }


    public static void main(String[] args) {

        Integer[] intarray=new Integer[]{1,2,3,4,5};
        //List<Integer> list= Arrays.asList(intarray);
        List<Integer> list=new ArrayList<>();
        list=Arrays.asList(intarray);
//External iterations
        for(int i=0;i<intarray.length;i++){
            System.out.println(list.get(i));
        }
        for(Integer i: list){
            System.out.println(i);
        }
        Iterator<Integer> i=list.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        //Internal Iterations
        System.out.println("Internal Iteratoons");
        list.forEach(ii-> System.out.println(ii));
        list.forEach(ExternalIteration::doubleInt);


    }
}
