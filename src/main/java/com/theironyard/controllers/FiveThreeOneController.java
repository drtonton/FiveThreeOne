package com.theironyard.controllers;
import com.theironyard.entities.Calculation;
import com.theironyard.entities.Max;
import com.theironyard.entities.Person;
import com.theironyard.services.CalculationRepository;
import com.theironyard.services.MaxRepository;
import com.theironyard.services.PersonRepository;
import com.theironyard.utils.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
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

//    @Autowired
//    NoteRepository noteRepository;
    @Autowired
    CalculationRepository calculationRepository;

    @RequestMapping(path ="/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("userName");
        Person person = personRepository.findFirstByUserName(userName);
//        HashMap calculations = new HashMap();
        ArrayList<Integer> calculations = new ArrayList<>();
        Max max = maxRepository.findFirstByPerson(person);
        if (person != null && max != null) {
//            calculations.put("benchA1", weekOne(max.getBench()).get(0));
//            calculations.put("benchA2", weekOne(max.getBench()).get(1));
//            calculations.put("benchA3", weekOne(max.getBench()).get(2));
            for (int i : weekOne(max.getBench())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("pressA1", weekOne(max.getShoulderPress()).get(0));
//            calculations.put("pressA2", weekOne(max.getShoulderPress()).get(1));
//            calculations.put("pressA3", weekOne(max.getShoulderPress()).get(2));
            for (int i : weekOne(max.getShoulderPress())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("squatA1", weekOne(max.getSquat()).get(0));
//            calculations.put("squatA2", weekOne(max.getSquat()).get(1));
//            calculations.put("squatA3", weekOne(max.getSquat()).get(2));
            for (int i : weekOne(max.getSquat())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("liftA1", weekOne(max.getDeadLift()).get(0));
//            calculations.put("liftA2", weekOne(max.getDeadLift()).get(1));
//            calculations.put("liftA3", weekOne(max.getDeadLift()).get(2));
            for (int i : weekOne(max.getDeadLift())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("benchB1", weekTwo(max.getBench()).get(0));
//            calculations.put("benchB2", weekTwo(max.getBench()).get(1));
//            calculations.put("benchB3", weekTwo(max.getBench()).get(2));
            for (int i : weekTwo(max.getBench())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("pressB1", weekTwo(max.getShoulderPress()).get(0));
//            calculations.put("pressB2", weekTwo(max.getShoulderPress()).get(1));
//            calculations.put("pressB3", weekTwo(max.getShoulderPress()).get(2));
            for (int i : weekTwo(max.getShoulderPress())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("squatB1", weekTwo(max.getSquat()).get(0));
//            calculations.put("squatB2", weekTwo(max.getSquat()).get(1));
//            calculations.put("squatB3", weekTwo(max.getSquat()).get(2));
            for (int i : weekTwo(max.getSquat())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("liftB1", weekTwo(max.getDeadLift()).get(0));
//            calculations.put("liftB2", weekTwo(max.getDeadLift()).get(1));
//            calculations.put("liftB3", weekTwo(max.getDeadLift()).get(2));
            for (int i : weekTwo(max.getDeadLift())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("benchC1", weekThree(max.getBench()).get(0));
//            calculations.put("benchC2", weekThree(max.getBench()).get(1));
//            calculations.put("benchC3", weekThree(max.getBench()).get(2));
            for (int i : weekThree(max.getBench())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("pressC1", weekThree(max.getShoulderPress()).get(0));
//            calculations.put("pressC2", weekThree(max.getShoulderPress()).get(1));
//            calculations.put("pressC3", weekThree(max.getShoulderPress()).get(2));
            for (int i : weekThree(max.getShoulderPress())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("squatC1", weekThree(max.getSquat()).get(0));
//            calculations.put("squatC2", weekThree(max.getSquat()).get(1));
//            calculations.put("squatC3", weekThree(max.getSquat()).get(2));
            for (int i : weekThree(max.getSquat())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("liftC1", weekThree(max.getDeadLift()).get(0));
//            calculations.put("liftC2", weekThree(max.getDeadLift()).get(1));
//            calculations.put("liftC3", weekThree(max.getDeadLift()).get(2));
            for (int i : weekThree(max.getDeadLift())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("benchD1", weekFour(max.getBench()).get(0));
//            calculations.put("benchD2", weekFour(max.getBench()).get(1));
//            calculations.put("benchD3", weekFour(max.getBench()).get(2));
            for (int i : weekFour(max.getBench())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("pressD1", weekFour(max.getShoulderPress()).get(0));
//            calculations.put("pressD2", weekFour(max.getShoulderPress()).get(1));
//            calculations.put("pressD3", weekFour(max.getShoulderPress()).get(2));
            for (int i : weekFour(max.getShoulderPress())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("squatD1", weekFour(max.getSquat()).get(0));
//            calculations.put("squatD2", weekFour(max.getSquat()).get(1));
//            calculations.put("squatD3", weekFour(max.getSquat()).get(2));
            for (int i : weekFour(max.getSquat())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
//            calculations.put("liftD1", weekFour(max.getDeadLift()).get(0));
//            calculations.put("liftD2", weekFour(max.getDeadLift()).get(1));
//            calculations.put("liftD3", weekFour(max.getDeadLift()).get(2));
            for (int i : weekFour(max.getDeadLift())) {
                Calculation calc = new Calculation(i, person);
                calculationRepository.save(calc);
            }
            model.addAttribute("calculated", calculationRepository.findByPerson(person));
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
    public String addMax(HttpSession session, int bench, int squat, int shoulderPress, int deadLift) throws Exception {
        String userName = (String) session.getAttribute("userName");
        Person person = personRepository.findFirstByUserName(userName);
        Max max = new Max(bench, squat, shoulderPress, deadLift, person);
        if (bench >= 1 && squat >= 1 && shoulderPress >= 1 && deadLift >= 1) {
            if (maxRepository.findFirstByPerson(person) == null) {
                maxRepository.save(max);
            }
            else {
                Max oldMax = maxRepository.findFirstByPerson(person);
                maxRepository.delete(oldMax);
                maxRepository.save(max);
            }
        }
        else if (bench <= 1 || squat <= 1 || shoulderPress <= 1 || deadLift <= 1) {
            return "redirect:/";
        }
        return "redirect:/";
    }
//    @RequestMapping(path = "/addNote", method = RequestMethod.POST)
//    public String addNote(HttpSession session, String text) {
//        String userName = (String) session.getAttribute("userName");
//        Note note = new Note(text, personRepository.findFirstByUserName(userName));
//        noteRepository.save(note);
//        return "redirect:/";
//    }

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
