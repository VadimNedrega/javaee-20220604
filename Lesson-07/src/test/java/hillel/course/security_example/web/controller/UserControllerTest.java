package hillel.course.security_example.web.controller;

import hillel.course.security_example.data.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
class UserControllerTest {
    @Autowired
    DataSource dataSource;

    @Test
    void userNotAdmin() throws SQLException {

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select Username from Authorities where Authority = 'ROLE_USER'");

        User user = new User();
        while (rs.next()) {
            user.setUsername(rs.getString("Username"));
        }
        Assertions.assertNotEquals(true, user.isAdmin());

    }

}