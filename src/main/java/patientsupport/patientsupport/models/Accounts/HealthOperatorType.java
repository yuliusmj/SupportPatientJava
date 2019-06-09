package patientsupport.patientsupport.models.Accounts;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Set;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "HealthOperatorsTypes")
public class HealthOperatorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "This field is required")
    @Length(max = 100)
    private String description;

    private boolean active;

    @OneToMany(mappedBy = "HealthOperatorsTypes",cascade = CascadeType.ALL)
    private Set<HealthOperatorAccount>HealthOperatorAccounts;

    public  HealthOperatorType(int Id, String Description,boolean Active){

        this.id = Id;
        this.description = Description;
        this.active = Active;
    }

    //#region Getters and Setters
    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
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

    public void setId(int id) {
        this.id = id;
    }
    //#endregion


    
}