package patientsupport.patientsupport.models.cases;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Case
 */
 @Entity
 @Table(name = "Cases")
public class Case {

    private int id;


















    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}