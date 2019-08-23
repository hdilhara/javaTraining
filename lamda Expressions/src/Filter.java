import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
        printStudentsWithShortnames();
        fiterWithStream();
        process();
        maxId();
        minId();
        countStudents();
    }



    static void printStudentsWithShortnames(){
        List<Student> students = Student.getStudent();

        for (Student student:students){
            if(student.getName().length()<=6){
                System.out.println(student.getName());
            }
        }
    }

    static void fiterWithStream(){
        List<Student> students = Student.getStudent().stream().filter(s->s.getName().length()<=6).collect(Collectors.toList());
        System.out.println(students);
    }

    static  void process(){
        List<Student> students = Student.getStudent().stream().map(s->new Student("Dr "+s.getName(),s.getId())).collect(Collectors.toList());
        System.out.println(students);
        Student.getStudent().stream().map(s->new Student("Dr "+s.getName(),s.getId())).collect(Collectors.toList()).forEach(s-> System.out.println(s));
    }


    static void maxId(){
        Student std=Student.getStudent().stream().max(Comparator.comparing(s->s.getId())).get();
        System.out.println("max ID :"+std);
    }

    static void minId(){
        Student std=Student.getStudent().stream().min(Comparator.comparing(s->s.getId())).get();
        System.out.println("min ID :"+std);
    }

    static void countStudents(){
        long count=Student.getStudent().stream().count();
        System.out.println("No. of Students :"+count);
    }
}