package patientsupport.patientsupport.models.Accounts;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "Physicians")
public class Physician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty(message = "This field is required")
    @Length(max = 50)
    private String firstName;

    @NotEmpty(message = "This field is required")
    @Length(max = 50)
    private String lastName;

    @NotEmpty(message = "This field is required")
    @Length(max = 50)
    private String phone;

    
    @Length(max = 100)
    private String accountName;

    private boolean active;


    @ManyToOne
    @JoinColumn
    public SpecialistType specialistType;

    public Physician (int id){
        this.id = id;
    }


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