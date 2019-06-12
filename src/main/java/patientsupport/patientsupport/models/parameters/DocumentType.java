package patientsupport.patientsupport.models.parameters;


import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
// import patientsupport.patientsupport.models.accounts.Patient;

@Entity
@Table(name = "DocumentTypes")
public class DocumentType extends Audit<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(max = 50)
    private String description; 

    @Length(max = 20)
    private String alias;

    // @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    // @JoinColumn(name = "PatientId")
    // private Set<Patient> patients;

    public int getId() {
        return id;
    }

    // public Set<Patient> getPatients() {
    //     return patients;
    // }

    // public void setPatients(Set<Patient> patients) {
    //     this.patients = patients;
    // }

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