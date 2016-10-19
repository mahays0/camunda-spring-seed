package edu.rosehulman.services;

import edu.rosehulman.model.JobEntity;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.logging.Logger;

/**
 * This code relates to a second example about hiring people.
 * It has nothing to do with today's example.
 * 
 * Created by mhays on 7/1/16.
 */
@Named
public class PostJobDelegate implements JavaDelegate {
    @Autowired
    private JobsService service;

    private Logger logger = Logger.getLogger("POST_JOB");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
       service.save(new JobEntity(
               (String)execution.getVariable("name"),
               (String)execution.getVariable("desc")
       ));
    }
}
