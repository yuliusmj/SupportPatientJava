package patientsupport.patientsupport.models.accounts;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import patientsupport.patientsupport.models.parameters.Audit;

import java.util.Set;

@Entity
@Table(name = "HealthOperatorsTypes")
public class HealthOperatorType extends Audit<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{label.required}")
    @Length(max = 100)
    private String description;

    private boolean active;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "HealthOperatorTypeId")
    private Set<HealthOperatorAccount> healthOperatorAccounts;

    // #region Getters and Setters
    public int getId() {
        return id;
    }

    public Set<HealthOperatorAccount> getHealthOperatorAccounts() {
        return healthOperatorAccounts;
    }

    public void setHealthOperatorAccounts(Set<HealthOperatorAccount> healthOperatorAccounts) {
        this.healthOperatorAccounts = healthOperatorAccounts;
    }

    public boolean getActive() {
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