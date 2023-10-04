package in.mindcraft.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import in.mindcraft.dao.UserDao;
import in.mindcraft.pojos.User;


@Controller
@CrossOrigin("*")
public class UserController {

    private final UserDao userdao;

    @Autowired
    public UserController(UserDao userdao) {
        this.userdao = userdao;
    }

    // Submit data
    @RequestMapping("/api/users")
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(username, email, password);

        try {
            if (userdao.addUser(user)) {
                System.out.println("User added successfully");
            }
        } catch (Exception e) {
            System.out.println("Failed to add");
        }
    }


}

