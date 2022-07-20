package hillel.course.security_example.web.controller;

import hillel.course.security_example.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    DataSource dataSource;

    @GetMapping
    @Secured("ROLE_ADMIN")
    public String getAllAdmins() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select Username from Authorities");

        while (rs.next()) {
            User user = new User();
            user.setUsername(rs.getString("Username"));
            users.add(user);
        }
        return "List of all users: " + users;
    }

}
