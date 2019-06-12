package tn.insat.eservices.tp2.HelloworldCamunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class ProcessRequestDelegate  implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("Hello-Greetings");

    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Hey! " + execution.getVariable("salutation")
                + " " + execution.getVariable("nom") + "!"  +
                "! La température aujourd'hui à "
                + execution.getVariable("ville")
                + " est de "
                + execution.getVariable("WsResponse")+"!");
    }
}
