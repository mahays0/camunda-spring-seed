package edu.rosehulman.repos;

import edu.rosehulman.model.JobEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * This code relates to a second example about hiring people.
 * It has nothing to do with today's example.
 * 
 * Created by mhays on 7/1/16.
 */
public interface JobsRepo extends CrudRepository<JobEntity, Long> {
}
