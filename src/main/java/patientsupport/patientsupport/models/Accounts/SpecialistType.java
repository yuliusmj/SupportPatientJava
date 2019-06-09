package patientsupport.patientsupport.models.Accounts;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;



@Entity
@Table(name = "SpecialistTypes")
public class SpecialistType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "This field is required")
    @Length(max = 50)
    private String Description;


    @OneToMany(mappedBy = "SpecialistType",cascade = CascadeType.ALL)
    private Set<Physician> Physicians; 

    public int getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}