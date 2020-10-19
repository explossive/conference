package io.dimax.conference.controller;

import io.dimax.conference.repository.LectureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private final LectureRepository lectureRepository;

    public MainController(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("lectures", lectureRepository.findAll());
        return "index";
    }
}
