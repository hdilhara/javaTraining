import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<String> names=new ArrayList<>();

        names.add("Thilina");
        names.add("Jayasaman");
        names.add("Pubudu");
        names.add("Deshan");
        names.add("Shalitha");
        names.add("Ruchineth");
        names.add("Mike");
        names.add("Stevan");
        names.add("Shown");
        names.add("Jesica");


        System.out.println(names);
        System.out.println("After sorting");
        Collections.sort(names);
        System.out.println(names);


        List<Student> students=new ArrayList<>();

        students.add(new Student(111,"Thilina","Kiribathgoda"));
        students.add(new Student(254,"Jayasaman","JaEla"));
        students.add(new Student(241,"Pubudu","Hambanthoda"));
        students.add(new Student(14,"Deshan","Megamuwa"));
        students.add(new Student(471,"Shalitha","Kadawatha"));
        students.add(new Student(18,"Ruchineth","Kurunagala"));
        students.add(new Student(411,"Mike","Nuwara"));
        students.add(new Student(41,"Stevan","Wattala"));
        students.add(new Student(59,"Shown","Colombo"));
        students.add(new Student(63,"Jesica","Negambo"));

        System.out.println(students);
        System.out.println("After sorting");
        Collections.sort(students);  /** overriding default sorting way*/
        System.out.println(students);

        System.out.println("After using comparator");
        CustomComarator comarator=new CustomComarator();
        Collections.sort(students,comarator);
        System.out.println(students);

    }
}
