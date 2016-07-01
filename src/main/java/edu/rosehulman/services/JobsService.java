package edu.rosehulman.services;

import edu.rosehulman.model.JobEntity;
import edu.rosehulman.repos.JobsRepo;
import org.camunda.bpm.engine.delegate.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by mhays on 7/1/16.
 */
@Service
public class JobsService {
    @Autowired
    private JobsRepo repo;

    private Expression name;
    private Expression desc;

    private Logger logger = Logger.getLogger("SERVICE");

    public void save(JobEntity j){
        repo.save(j);
    }

}
