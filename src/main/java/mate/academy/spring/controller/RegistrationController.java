package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.dto.UserRegistrationDto;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping()
    public String addUserPage() {
        return "registration";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute @Valid UserRegistrationDto dto) {
        User user = new User(
                dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getUsername(),
                passwordEncoder.encode(dto.getPassword()));
        userService.add(user);
        return "login";
    }
}
