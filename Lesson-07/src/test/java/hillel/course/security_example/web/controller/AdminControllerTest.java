package hillel.course.security_example.web.controller;

import hillel.course.security_example.data.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AdminControllerTest {
    @Test
    void checkAdminRights() {
        User user = new User();
        user.setAdmin(true);

        assertTrue(user.isAdmin());
    }
}