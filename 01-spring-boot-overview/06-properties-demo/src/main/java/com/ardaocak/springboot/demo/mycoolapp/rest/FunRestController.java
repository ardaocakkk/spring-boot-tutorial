package com.ardaocak.springboot.demo.mycoolapp.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    @GetMapping("teaminfo")
    public String getTeamInfo() {
        return "Coach Name: " + coachName + " Team Name: " + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }

    @GetMapping("/working")
    public String checkWorking() {
        return "Autocompile is working correctly";
    }
}
