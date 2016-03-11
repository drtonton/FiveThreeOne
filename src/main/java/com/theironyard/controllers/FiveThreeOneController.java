package com.theironyard.controllers;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.theironyard.entities.Max;
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
import java.util.ArrayList;
import java.util.HashMap;

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
    public String home(HttpSession session, Model model, int id) {
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
    @RequestMapping(path = "/addMax", method = RequestMethod.POST)
    public String addMax(HttpSession session, int bench, int squat, int shoulderPress, int deadLift) {
        String userName = (String) session.getAttribute("userName");
        Person person = personRepository.findFirstByUserName(userName);
        Max max = new Max(bench, squat, shoulderPress, deadLift, person);
        maxRepository.save(max);
        return "redirect:/";
    }
    static ArrayList<Integer> weekOne (int amt) {
        int a1 = (int) Math.round(amt*.65);
        int a2 = (int) Math.round(amt*.75);
        int a3 = (int) Math.round(amt*.85);
        ArrayList calculatedAmts = new ArrayList();
        calculatedAmts.add(0, a1);
        calculatedAmts.add(1, a2);
        calculatedAmts.add(2, a3);
        return calculatedAmts;
    }
    static ArrayList<Integer> weekTwo (int amt) {
        int b1 = (int) Math.round(amt*.70);
        int b2 = (int) Math.round(amt*.80);
        int b3 = (int) Math.round(amt*.90);
        ArrayList calculatedAmts = new ArrayList();
        calculatedAmts.add(0, b1);
        calculatedAmts.add(1, b2);
        calculatedAmts.add(2, b3);
        return calculatedAmts;
    }
    static ArrayList<Integer> weekThree (int amt) {
        int c1 = (int) Math.round(amt*.75);
        int c2 = (int) Math.round(amt*.85);
        int c3 = (int) Math.round(amt*.95);
        ArrayList calculatedAmts = new ArrayList();
        calculatedAmts.add(0, c1);
        calculatedAmts.add(1, c2);
        calculatedAmts.add(2, c3);
        return calculatedAmts;
    }
    static ArrayList<Integer> weekFour (int amt) {
        int d1 = (int) Math.round(amt*.40);
        int d2 = (int) Math.round(amt*.50);
        int d3 = (int) Math.round(amt*.60);
        ArrayList calculatedAmts = new ArrayList();
        calculatedAmts.add(0, d1);
        calculatedAmts.add(1, d2);
        calculatedAmts.add(2, d3);
        return calculatedAmts;
    }
}
