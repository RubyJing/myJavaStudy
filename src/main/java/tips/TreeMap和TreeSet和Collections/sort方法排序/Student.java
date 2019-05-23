package tips.TreeMap和TreeSet和Collections.sort方法排序;

public class Student implements Comparable<Student> {
    /** 姓名 */
    private String name;
    /** 年龄 */
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        //比较年龄（年龄的升序）
        return this.age - o.age;
    }
}
