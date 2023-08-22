import com.chxy.dao.StudentDAO;
import com.chxy.daomain.Student;
import com.chxy.utils.Utility;
import com.chxy.view.SMSView;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author chxy
 * @version 1.0
 */
public class TestDAO {

    @Test
    public void testStudentDAO() {
        StudentDAO studentDAO = new StudentDAO();
        String sql = "select * from student where sno >= ?";

        List<Student> students = studentDAO.queryMulti(sql, Student.class, 1);
        for (Student student : students) {
            System.out.println(student);
        }

        Student student = studentDAO.querySingle("select * from student where sno = ?", Student.class, 4);
        System.out.println(student);

        Object o = studentDAO.queryScalar("select sname from student where sno = ?", 2);
        System.out.println(o);
    }

}
