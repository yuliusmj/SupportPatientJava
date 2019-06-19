package patientsupport.patientsupport.models.cases;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import patientsupport.patientsupport.models.parameters.LabType;
import patientsupport.patientsupport.models.cases.Case;

/**
 * lab
 */
@Entity
@Table(name = "Labs")
public class lab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "This Field is required")
    @Length(max = 50)
    private String laboratoryName;

    @NotEmpty
    private Date requestDate;

    private Date resultDate;

    private int labTypeId;

    private int caseId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "labTypeId", referencedColumnName = "id")
    @Where(clause = "identificador ='labType'")
    @JsonIgnore
    private LabType labTypes;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "caseId", referencedColumnName = "id")
    @Where(clause = "identificador ='cases'")
    @JsonIgnore
    private Case cases;

    public int getId() {
        return id;
    }

    public Case getCases() {
        return cases;
    }

    public void setCases(Case cases) {
        this.cases = cases;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public void setLabType(LabType labType) {
        this.labTypes = labType;
    }

    public int getLabType() {
        return labTypeId;
    }

    public void setLabType(int labType) {
        this.labTypeId = labType;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    

    
}