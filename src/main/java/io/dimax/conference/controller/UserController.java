package io.dimax.conference.controller;

import io.dimax.conference.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/all";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/registration";
    }
}
