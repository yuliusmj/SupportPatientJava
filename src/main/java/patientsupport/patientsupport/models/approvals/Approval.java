package patientsupport.patientsupport.models.approvals;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;



/**
 * Approval
 * 
 * @param <Case>
 */
@Entity
@Table(name = "Approvals")
public class Approval<Case> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "This field is required")
    @Length(max = 10)
    private String approvalType;

    private Date approvalDate;

    private Boolean approved;

    private Date approvalExpirationDate;

    private int caseId;

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

    public Date getApprovalExpirationDate() {
        return approvalExpirationDate;
    }

    public void setApprovalExpirationDate(Date approvalExpirationDate) {
        this.approvalExpirationDate = approvalExpirationDate;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}