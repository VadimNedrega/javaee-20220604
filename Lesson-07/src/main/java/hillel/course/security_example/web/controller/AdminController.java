package hillel.course.security_example.web.controller;

import hillel.course.security_example.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    DataSource dataSource;
    Set<User> admins = new HashSet<>();

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String getAllAdmins(Model model) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select Username from Authorities where Authority = 'ROLE_ADMIN'");

        while (rs.next()) {
            User user = new User();
            user.setUsername(rs.getString("Username"));
            user.setAdmin(true);
            admins.add(user);
        }

        model.addAttribute("admins", admins);
        return "admin";
    }

}
