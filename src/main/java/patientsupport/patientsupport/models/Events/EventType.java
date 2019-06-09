package patientsupport.patientsupport.models.Events;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "EventTypes")
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty(message = "This field is required")
    @Length(max = 50)
    private String description;
    
    private boolean active;

    @OneToMany(mappedBy = "EventTypes", cascade = CascadeType.ALL)
    private Set<Event> Events;

    public boolean isActive() {
        return active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    


    
}