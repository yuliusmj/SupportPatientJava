package patientsupport.patientsupport.models.parameters;


import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "zones")
public class Zone {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "This field is required")
    @Length(max = 100)
    private String description;

    private boolean active;
    
    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private Set<Country> countries;

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



    
}