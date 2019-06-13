package com.appWeather.appWheather;



import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;

public class CheckWeatherDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Random rando=new Random();
        execution.setVariable("Name","Aziz");
        execution.setVariable("WeatherOk",rando.nextBoolean());

    }
}
