
package op.datasource.PostGre.model;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int rollno, marks;
    private String name;
    
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Roll No.: " + rollno + " | Name: " + name + " | marks: " + marks + "\n";
    }
}
