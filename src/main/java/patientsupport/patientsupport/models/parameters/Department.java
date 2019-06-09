package patientsupport.patientsupport.models.parameters;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Departments")
public class Department {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "This field is required")
    @Length(max = 100)
    private String description;

    @OneToMany(mappedBy = "City", cascade = CascadeType.ALL)
    private Set<City> Cities;

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}