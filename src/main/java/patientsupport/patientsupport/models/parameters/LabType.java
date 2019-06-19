package patientsupport.patientsupport.models.parameters;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import  patientsupport.patientsupport.models.cases.lab;

/**
 * LabType
 */
@Entity
@Table(name = "LabTypes", uniqueConstraints = @UniqueConstraint(columnNames = { "description" }))
public class LabType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "This field is required")
    @Length(max = 50)
    private String description;

    private boolean active;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "LabId")
    @JsonIgnore
    private Set<lab> labs;


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


    
}