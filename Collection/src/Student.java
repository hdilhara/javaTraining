public class Student implements Comparable<Student>{
    /**We implements with Comparable interface & @override it compareTo() method to tell
       what is use to when sorting
     */
    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.name);
    }

    private Integer id;
    private String name;
    private String city;

    public Student(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
