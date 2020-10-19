package io.dimax.conference.controller;

import io.dimax.conference.repository.LectureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class LectureController {

    private final LectureRepository lectureRepository;

    public LectureController(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @RequestMapping(value = "/lecture/{id}", method = RequestMethod.GET)
    public String index(Model model, @PathVariable("id") int id) {
        model.addAttribute("lecture", lectureRepository.findById(id));
        return "lecture";
    }
}
