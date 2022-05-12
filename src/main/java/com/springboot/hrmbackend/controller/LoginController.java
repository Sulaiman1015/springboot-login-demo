package com.springboot.hrmbackend.controller;

import com.springboot.hrmbackend.exception.PasswordErrorException;
import com.springboot.hrmbackend.exception.UserNotFoundException;
import com.springboot.hrmbackend.model.User;
import com.springboot.hrmbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserRepository userRepository;
   /* @Autowired
    private HttpSession session;*/
    @PostMapping(value = "/login")
    public String login(String username, String password, HttpSession session
            /*, Map<String, Object> map, Model model*/) {

        //get username and password from sql
        User user = userRepository.findByUsername(username);
        String name = user.getUsername();
        String pwd = user.getPassword();
        if(name == null){
            throw new UserNotFoundException(name+" user not found!");
        }else if(pwd != null){
            if (name.equals(username) && pwd.equals(password)) {
                session.setAttribute("Username", username);
                return "api/emplist";
            } else {
                //map.put("msg", "username or password is wrong!");
                throw new PasswordErrorException("Your password is error");
            }
        }

        return "api/login";
    }
}
