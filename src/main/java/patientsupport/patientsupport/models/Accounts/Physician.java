package patientsupport.patientsupport.models.accounts;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import patientsupport.patientsupport.models.cases.Case;
import patientsupport.patientsupport.models.parameters.Audit;


@Entity
@Table(name = "Physicians")
public class Physician extends Audit<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty(message = "{label.required}")
    @Length(max = 50)
    private String firstName;

    @NotEmpty(message = "{label.required}")
    @Length(max = 50)
    private String lastName;

    @NotEmpty(message = "{label.required}")
    @Length(max = 50)
    private String phone;

    @Length(max = 100)
    private String accountName;

    private boolean active;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "physicianId")
    @JsonIgnore
    private Set<Case> cases;


    //#region getters and Setters

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    //#endregion

    
}