package patientsupport.patientsupport.models.Events;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    @Length(max = 100)
    private String subject;

    @NotEmpty
    private int asssignedTo;

    @NotEmpty
    private Date startDate;

    @NotEmpty
    private Date endDate;

    @NotEmpty
    private Time startTime;

    @NotEmpty
    private Time endTime;

    @Length(max = 255)
    private String observations;

    @ManyToOne
    @JoinColumn
    private EventType eventtype;


    public int getId() {
        return id;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getAsssignedTo() {
        return asssignedTo;
    }

    public void setAsssignedTo(int asssignedTo) {
        this.asssignedTo = asssignedTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    
}