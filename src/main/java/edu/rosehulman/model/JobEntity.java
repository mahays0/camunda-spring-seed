package edu.rosehulman.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mhays on 7/1/16.
 */
@Entity
public class JobEntity {
    @Id
    @GeneratedValue
    private long id;

    public String name;
    public String desc;
    public JobEntity(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
}
