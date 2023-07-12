package com.ocakarda.springcoredemo.rest;

import com.ocakarda.springcoredemo.common.Coach;
import com.ocakarda.springcoredemo.common.CricketCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach) {
        System.out.println("In constructor" + getClass().getSimpleName());
        myCoach = theCoach;

    }


    @GetMapping("/dailyworkout")
    String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
