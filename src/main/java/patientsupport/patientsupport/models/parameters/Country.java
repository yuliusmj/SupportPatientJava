package patientsupport.patientsupport.models.parameters;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "countries")
public class Country {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "This field is required")
    @Length(max = 100)
    private String description;

    @ManyToOne
    @JoinColumn
    private Zone zone;


    //Getters and Setters
    public int getId(){
        return id;
    }

    public void setId(int Id){
        this.id = Id;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}