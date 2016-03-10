package com.theironyard;

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

    @RequestMapping(path="/", method= RequestMethod.GET)
    public String home(HttpSession session, Model model) {

        model.addAttribute("person", person)
        return "home";
    }
}
