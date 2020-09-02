package com.github.perscholas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {
    @Autowired
    private PersonService personService;

    @GetMapping
    String getView(Model model) {
        List<Person> personList = personService.readAll();
        model.addAttribute("message", personList.toString());
        return "welcome";
    }
}