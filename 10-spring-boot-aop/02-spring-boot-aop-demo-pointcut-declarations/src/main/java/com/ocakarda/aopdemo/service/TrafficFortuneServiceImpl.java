package com.ocakarda.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Except heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire) {
            throw  new RuntimeException("major accident! highway is closed");
        }
        return "except heavy traffic this morning";
    }
}
