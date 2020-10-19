package io.dimax.conference.repository;

import io.dimax.conference.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Lecture findById(int id);
}