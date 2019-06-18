package patientsupport.patientsupport.models.accounts;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import patientsupport.patientsupport.models.parameters.Audit;

@Entity
@Table(name = "SpecialistTypes")
public class SpecialistType extends Audit<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{label.required}")
    @Length(max = 50)
    private String description;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "SpecialistTypeId")
    private Set<Physician> physicians;

    public int getId() {
        return id;
    }

    public Set<Physician> getPhysicians() {
        return physicians;
    }

    public void setPhysicians(Set<Physician> physicians) {
        this.physicians = physicians;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}