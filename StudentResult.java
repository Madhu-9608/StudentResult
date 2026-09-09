import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentResult {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Arun", 85),
            new Student("Priya", 92),
            new Student("Kavin", 35),
            new Student("Divya", 90),
            new Student("Ravi", 28));

        List<String> passedStudents = students.stream()
            .filter(s -> s.marks >= 40)
            .map(s -> s.name + " - passed " + s.marks + " marks")
            .collect(Collectors.toList());

        System.out.println("Passed students:");

        passedStudents.forEach(System.out::println);
    }
}
