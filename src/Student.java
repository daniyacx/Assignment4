import java.util.Objects;

public class Student {
    private String name;
    private int group;
    private float gpa;
    public Student(String name, int group, float gpa){
        this.group = group;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = hash * 5 + group;
        hash = hash * 7 + (int) gpa;

        char[] letters = name.toCharArray();
        int a = 0;
        for (char i: letters) a = i + (31 * a);

        hash = hash * 13 + a;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return group == student.group && Float.compare(student.gpa, gpa) == 0 && Objects.equals(name, student.name);
    }
}