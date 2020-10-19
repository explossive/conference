package io.dimax.conference.controller.clientapi;

import io.dimax.conference.form.RegistrationConferenceForm;
import io.dimax.conference.model.Lecture;
import io.dimax.conference.model.User;
import io.dimax.conference.repository.LectureRepository;
import io.dimax.conference.repository.UserRepository;
import io.dimax.conference.service.LeadSenderService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class UserRestController {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;
    private final LeadSenderService leadSenderService;

    public UserRestController(
            UserRepository userRepository,
            LeadSenderService leadSenderService,
            LectureRepository lectureRepository) {
        this.userRepository = userRepository;
        this.leadSenderService = leadSenderService;
        this.lectureRepository = lectureRepository;
    }

    @RequestMapping(value="/clientapi/user/registration",produces="application/json",
            consumes="application/json",method=RequestMethod.POST)
    public Object getBook(@RequestBody @Valid RegistrationConferenceForm registrationForm,
                          BindingResult bindingResult) {
        System.out.println(registrationForm.toString());
        if (bindingResult.hasErrors()) {
            return false;
        }
        User user = new User();
        user.setName(registrationForm.getName());
        user.setLastName(registrationForm.getLastName());
        user.setPhone(registrationForm.getPhone());
        user.setEmail(registrationForm.getEmail());
        user.setSubdivision(registrationForm.getSubdivision());
        userRepository.save(user);
        if(registrationForm.getSpeaker()){
            Lecture lecture = new Lecture();
            lecture.setTopic(registrationForm.getTopicLecture());
            lecture.setDescription(registrationForm.getDescriptionLecture());
            lecture.setSpeaker(user);
            lectureRepository.saveAndFlush(lecture);
        }

        return true;
    }
}
