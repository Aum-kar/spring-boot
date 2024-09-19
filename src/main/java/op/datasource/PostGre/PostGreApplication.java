
package op.datasource.PostGre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import op.datasource.PostGre.model.Student;
import op.datasource.PostGre.service.StudentService;

@SpringBootApplication
public class PostGreApplication
{
	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(PostGreApplication.class, args);

		Student s = context.getBean(Student.class);
		StudentService service = context.getBean(StudentService.class);

		System.out.println("---------------------------------------");
		
		s.setRollno(1);
		s.setName("Om");
		s.setMarks(85);

		service.add(s);
		service.showStudents();
		service.removeStudent(1);
		service.showStudents();

		System.out.println("---------------------------------------");
	}
}
