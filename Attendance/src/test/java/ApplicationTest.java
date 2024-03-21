import com.system.Attendance.AttendanceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = AttendanceApplication.class)
@ComponentScan("com.system.Attendance")
public class ApplicationTest {
    @Test
    void contextLoads() {
    }

}