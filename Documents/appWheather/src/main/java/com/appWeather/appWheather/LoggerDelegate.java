package com.appWeather.appWheather;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import sun.security.util.Length;

import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {

    final private Logger logger= Logger.getLogger(LoggerDelegate.class.getName());
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("process definition id:"+execution.getCurrentActivityId());


    }
}
