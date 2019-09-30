package StreamAPI;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {


    public static void main(String[] args) {

        //boolean a=true;
        List<Integer> list= Arrays.asList(123,22,322,143,235);
        //list.stream().forEach(i-> System.out.println(i*2));


        Function<Integer,Integer> function=new Function<Integer,Integer>(){
            @Override
            public Integer apply(Integer i) {
                i=i*2;
                return i;
            }
        };
        BinaryOperator<Integer> binaryOperator=new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return  integer+integer2;
            }
        };



        System.out.println(list);
        list.stream().map(function).forEach(i-> System.out.println(i));
        System.out.println(list.stream().map(function).reduce(binaryOperator));



        Stream<Integer> stream=list.stream();
        Optional<Integer> iii=stream.map(i->2).reduce((i,ii)->i+ii);
        System.out.println(iii.get());

        Optional<Integer> ii=list.stream().map(i->2).reduce((i, j)->i+j);
        System.out.println(ii.get());

        List<Integer> list1=list.stream().map(i->2).collect(Collectors.toList());
        System.out.println(list1);

        List<String> list2=Arrays.asList("Thilina","Dilhara","Shalitha");
        Optional<String > str2=list2.stream().map(i->i.toUpperCase()).reduce((i,ji)->i+ji);
        System.out.println(str2);

        Predicate<Integer> predicate=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer>250)
                    return true;
                else
                return false;
            }
        };
        List<Integer> list3=Arrays.asList(250,52,202,152,558,88,444);
        System.out.println(list3);
        list3=list3.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(list3);

        list3=Arrays.asList(250,52,202,152,558,88,444);
        System.out.println(list3);
        list3=list3.stream().map(i->i+100).filter(i->i>250).collect(Collectors.toList());
        System.out.println(list3);

        list3=Arrays.asList(250,52,202,152,558,88,444);
        System.out.println(list3);
        list3=list3.stream().filter(i->i<250).map(i->250).collect(Collectors.toList());
        System.out.println(list3);

        list3=Arrays.asList(250,52,202,152,558,88,444);
        System.out.println(list3);
        System.out.println(list3.stream().filter(i->i<250).findFirst().get());
        System.out.println(list3.stream().filter(i->i<250).findFirst().orElse(51));
        System.out.println(list3.stream().filter(i->i==558).findAny().orElse(00000));
        Optional<Integer> integer=list3.stream().filter(i->i==0).findAny();
        if (integer.isPresent()){
            System.out.println("There is such thing!");
        }
        else
            System.out.println("There is not such thing");

        list3=Arrays.asList(250,52,202,152,558,88,444);
        System.out.println(list3);
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               if (o1>o2)
                return 1;
               else if(o1<o2)
                   return -1;
               else
                   return 0;
            }
        };
        System.out.println("**********Find max min**********");
        Optional<Integer> intVal=Optional.empty();
        intVal=list3.stream().max(comparator);
        System.out.println(intVal.get());
        System.out.println("max Value :"+list3.stream().max(comparator ));
        System.out.println("min value :"+list3.stream().min(comparator));

        list3=Arrays.asList(250,52,202,152,558,88,444);
        System.out.println(list3);
        System.out.println(list3.stream().min((i,j)->{if(i>j){return 1;}else if(i<j){return -1;}else {return 0;}}) );
        list3.stream().sorted().forEach(i-> System.out.println(i));
        list3.stream().sorted((i,j)->{if(i>j){return -1;}else if(i<j){return 1;}else {return 0;}}).forEach(i-> System.out.println(i));
        System.out.println(list3.stream().min(Comparator.comparing(i->i)));
        list3.stream().sorted((i,j)->(i>j?-1:i<j?1:0)).forEach(i-> System.out.print(i+","));











    }
}
