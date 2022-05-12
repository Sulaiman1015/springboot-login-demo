package com.springboot.hrmbackend;

import com.springboot.hrmbackend.exception.PasswordErrorException;
import com.springboot.hrmbackend.exception.UserNotFoundException;
import com.springboot.hrmbackend.model.User;
import com.springboot.hrmbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@SpringBootTest
class WebApplicationTests {
  @Autowired
  private UserRepository userRepository;

  @Test
  public void findByName() {
    User user = userRepository.findByUsername("sulaiman");
    System.out.println(user.getPassword());
  }

  @Test
  public void findByUsernameAndPassword() {
    User user = userRepository.findByUsernameAndPassword("sulaiman","123");
    System.out.println(user.getRolename());
  }

}
