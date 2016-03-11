package com.theironyard.controllers;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.theironyard.entities.Person;
import com.theironyard.services.MaxRepository;
import com.theironyard.services.PersonRepository;
import com.theironyard.utils.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by noellemachin on 3/10/16.
 */
@Controller
public class FiveThreeOneController {
    @Autowired
    MaxRepository maxRepository;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(path ="/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("userName");
        Person person = personRepository.findFirstByUserName(userName);
        model.addAttribute("person", person);
        return "home";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) throws Exception {
        Person person = personRepository.findFirstByUserName(userName);
        if (person == null) {
            person = new Person(userName, PasswordStorage.createHash(password));
            personRepository.save(person);
        }
        else if (!PasswordStorage.verifyPassword(password, person.getPasswordHash())) {
            throw new Exception("Username and Password do not match!");
        }
        session.setAttribute("userName", userName);
        return "redirect:/";
    }
    @RequestMapping(path ="/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
