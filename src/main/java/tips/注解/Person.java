package tips.注解;

import java.lang.annotation.Annotation;

@TestInheritedAnnotation(values = {"value"}, number = 10)
public class Person {

}

class Student extends Person{

    public static void main(String[] args) {
        Student student = new Student();
        student.test();
    }

    public void test(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
    }
}
