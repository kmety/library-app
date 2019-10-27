package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.dto.UserRegistrationDto;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logoutSuccess")
    public String logout() {
        return "forward:/book/all";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute("userDto") @Valid UserRegistrationDto userDto,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "User creating error");
            return "errorPage";
        }
        try {
            userService.add(userDto);
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", e.getMessage());
            return "errorPage";
        }
        return "login";
    }
}
