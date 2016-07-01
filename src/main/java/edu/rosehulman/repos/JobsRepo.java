package edu.rosehulman.repos;

import edu.rosehulman.model.JobEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mhays on 7/1/16.
 */
public interface JobsRepo extends CrudRepository<JobEntity, Long> {
}
