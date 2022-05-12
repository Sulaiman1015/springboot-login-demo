package com.springboot.hrmbackend.repository;

import com.springboot.hrmbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
    //@Query("FROM userlist u WHERE u.username=:sulaiman")
    User findByUsername(String username);
}


