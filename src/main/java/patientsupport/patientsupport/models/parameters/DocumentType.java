package patientsupport.patientsupport.models.parameters;

import java.util.Set;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import patientsupport.patientsupport.models.Accounts.Patient;

@Entity
@Table(name = "DocumentTypes")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(max = 50)
    private String description; 

    @Length(max = 20)
    private String alias;

    @OneToMany(mappedBy = "Patient", cascade = CascadeType.ALL)
    private Set<Patient> Patients;


    public int getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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