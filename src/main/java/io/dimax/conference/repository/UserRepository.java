package io.dimax.conference.repository;

import io.dimax.conference.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}