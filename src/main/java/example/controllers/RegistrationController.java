package example.controllers;

import example.domain.Role;
import example.domain.UserAll;
import example.repos.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    //@Autowired

    private final UserRepo userRepo;

    public RegistrationController (UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @GetMapping("/registrations")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserAll user, Map<String, Object> model) {
        UserAll userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
