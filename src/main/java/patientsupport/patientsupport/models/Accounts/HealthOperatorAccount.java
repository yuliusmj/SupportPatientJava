package patientsupport.patientsupport.models.Accounts;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "HealthOperatorAccounts")
public class HealthOperatorAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "This field is required")
    @Length(max = 100)
    private String Description;


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