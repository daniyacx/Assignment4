import java.util.Objects;

public class Student {
    // The student's name
    private String name;
    // The student's group number
    private int group;
    // The student's grade point average
    private float gpa;
    /**
     constructs a new Student object with the specified name, group number, and grade point average
     @param name the student's name
     @param group the student's group number
     @param gpa the student's grade point average
     */
    public Student(String name, int group, float gpa){
        this.group = group;
        this.name = name;
        this.gpa = gpa;
    }
}