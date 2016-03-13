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
    public String home(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("userName");
        Person person = personRepository.findFirstByUserName(userName);
        HashMap calculations = new HashMap();
        Max max = maxRepository.findFirstByPerson(person);
        if (person != null && max != null) {
            // wk1s1B == week one, set one, Bench
            calculations.put("wk1s1B", weekOne(max.getBench()).get(0));
            calculations.put("wk1s2B", weekOne(max.getBench()).get(1));
            calculations.put("wk1s3B", weekOne(max.getBench()).get(2));

            calculations.put("wk1s1SP", weekOne(max.getShoulderPress()).get(0));
            calculations.put("wk1s2SP", weekOne(max.getShoulderPress()).get(1));
            calculations.put("wk1s3SP", weekOne(max.getShoulderPress()).get(2));

            calculations.put("wk1s1S", weekOne(max.getSquat()).get(0));
            calculations.put("wk1s2S", weekOne(max.getSquat()).get(1));
            calculations.put("wk1s3S", weekOne(max.getSquat()).get(2));

            calculations.put("wk1s1D", weekOne(max.getDeadLift()).get(0));
            calculations.put("wk1s2D", weekOne(max.getDeadLift()).get(1));
            calculations.put("wk1s3D", weekOne(max.getDeadLift()).get(2));

            calculations.put("wk2s1B", weekTwo(max.getBench()).get(0));
            calculations.put("wk2s2B", weekTwo(max.getBench()).get(1));
            calculations.put("wk2s3B", weekTwo(max.getBench()).get(2));

            calculations.put("wk2s1SP", weekTwo(max.getShoulderPress()).get(0));
            calculations.put("wk2s2SP", weekTwo(max.getShoulderPress()).get(1));
            calculations.put("wk2s3SP", weekTwo(max.getShoulderPress()).get(2));

            calculations.put("wk2s1S", weekTwo(max.getSquat()).get(0));
            calculations.put("wk2s2S", weekTwo(max.getSquat()).get(1));
            calculations.put("wk2s3S", weekTwo(max.getSquat()).get(2));

            calculations.put("wk2s1D", weekTwo(max.getDeadLift()).get(0));
            calculations.put("wk2s2D", weekTwo(max.getDeadLift()).get(1));
            calculations.put("wk2s3D", weekTwo(max.getDeadLift()).get(2));

            calculations.put("wk3s1B", weekThree(max.getBench()).get(0));
            calculations.put("wk3s2B", weekThree(max.getBench()).get(1));
            calculations.put("wk3s3B", weekThree(max.getBench()).get(2));

            calculations.put("wk3s1SP", weekThree(max.getShoulderPress()).get(0));
            calculations.put("wk3s2SP", weekThree(max.getShoulderPress()).get(1));
            calculations.put("wk3s3SP", weekThree(max.getShoulderPress()).get(2));

            calculations.put("wk3s1S", weekThree(max.getSquat()).get(0));
            calculations.put("wk3s2S", weekThree(max.getSquat()).get(1));
            calculations.put("wk3s3S", weekThree(max.getSquat()).get(2));

            calculations.put("wk3s1D", weekThree(max.getDeadLift()).get(0));
            calculations.put("wk3s2D", weekThree(max.getDeadLift()).get(1));
            calculations.put("wk3s3D", weekThree(max.getDeadLift()).get(2));

            calculations.put("wk4s1B", weekFour(max.getBench()).get(0));
            calculations.put("wk4s2B", weekFour(max.getBench()).get(1));
            calculations.put("wk4s3B", weekFour(max.getBench()).get(2));

            calculations.put("wk4s1SP", weekFour(max.getShoulderPress()).get(0));
            calculations.put("wk4s2SP", weekFour(max.getShoulderPress()).get(1));
            calculations.put("wk4s3SP", weekFour(max.getShoulderPress()).get(2));

            calculations.put("wk4s1S", weekFour(max.getSquat()).get(0));
            calculations.put("wk4s2S", weekFour(max.getSquat()).get(1));
            calculations.put("wk4s3S", weekFour(max.getSquat()).get(2));

            calculations.put("wk4s1D", weekFour(max.getDeadLift()).get(0));
            calculations.put("wk4s2D", weekFour(max.getDeadLift()).get(1));
            calculations.put("wk4s3D", weekFour(max.getDeadLift()).get(2));

            model.addAttribute("calculated", calculations);
        }
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
