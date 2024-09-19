
package op.datasource.PostGre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import op.datasource.PostGre.model.Student;
import op.datasource.PostGre.repository.StudentRepository;

@Service
public class StudentService
{
    private StudentRepository repo;

    @Autowired
    public void setRepo(StudentRepository repo) {
        this.repo = repo;
    }

    public void add(Student s) {
        System.out.println("Rows affected: " + repo.save(s));
    }

    public void showStudents() {
        System.out.println(repo.findAll());
    }

    public void removeStudent(int rollno) {
        System.out.println("Rows impacted: " + repo.delete(rollno));
    }
}
