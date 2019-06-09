package patientsupport.patientsupport.models;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "This field is required")
    private String firstName;

    @NotEmpty(message = "This field is required")
    private String lastName;

    private String phone;

    @Email
    @NotEmpty(message = "This field is required")
    private String email;

    @Length(min = 4, message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String password;

    // Many to many relationship
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", 
                joinColumns = @JoinColumn(name = "user_id"), 
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


}

