package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String index() {
        /*String name = "admin123";
        String email = "admin@admin.com";
        String password = "123456";
        Long id = (long)1;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(id, name, hashedPassword, email);
        Role admin = new Role(1, "ROLE_ADMIN");
        Role user_role = new Role(2, "ROLE_USER");
        userService.addRole(admin);
        userService.addRole(user_role);
        Set<Role> testRole = new HashSet<>();
        testRole.add(admin);
        testRole.add(user_role);
        user.setRoles(testRole);
        userService.addUser(user);*/
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "loginPage";
    }

}