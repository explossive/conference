package io.dimax.conference.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class RegistrationConferenceForm {

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String subdivision;

    @NotNull
    private Boolean speaker;

    private String topicLecture;

    private String descriptionLecture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public Boolean getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Boolean speaker) {
        this.speaker = speaker;
    }

    public String getTopicLecture() {
        return topicLecture;
    }

    public void setTopicLecture(String topicLecture) {
        this.topicLecture = topicLecture;
    }

    public String getDescriptionLecture() {
        return descriptionLecture;
    }

    public void setDescriptionLecture(String descriptionLecture) {
        this.descriptionLecture = descriptionLecture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
