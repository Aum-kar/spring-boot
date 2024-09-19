
package op.datasource.PostGre.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import op.datasource.PostGre.model.Student;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> findAll() {
        /*
        RowMapper<Student> mapper = new RowMapper<Student>() {
        
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws
            java.sql.SQLException {
                Student s = new Student();

                s.setRollno(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setMarks(rs.getInt(3));

                return s;
            };
        };
         */

         RowMapper<Student> mapper = (ResultSet rs, int rowNum) -> {
            Student s = new Student();
            s.setRollno(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setMarks(rs.getInt(3));
 
            return s;
        };

        String sql = "SELECT * FROM students";

        return jdbc.query(sql, mapper);
    }

    public int save(Student s) {
        String sql = "INSERT INTO students (rollno, name, marks) SET (?, ?, ?)";
        return jdbc.update(sql, s);
    }

    public int delete(int rollno) {
        String sql = "DELETE FROM students WHERE rollno = ?";
        return jdbc.update(sql, rollno);
    }
}
