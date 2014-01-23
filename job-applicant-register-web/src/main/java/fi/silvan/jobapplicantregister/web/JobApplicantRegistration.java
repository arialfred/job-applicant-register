package fi.silvan.jobapplicantregister.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import fi.silvan.jobapplicantregister.model.entity.JobApplicant;
import fi.silvan.jobapplicantregister.service.JobApplicantServiceBean;

@ManagedBean
@RequestScoped
public class JobApplicantRegistration {
	@EJB
	transient private JobApplicantServiceBean service;
	private JobApplicant jobApplicant = new JobApplicant();
	private JobApplicant jobApplicantForConfirmationDialog;
	
	public JobApplicant getJobApplicant() {
		return jobApplicant;
	}
	
	public void setJobApplicant(JobApplicant jobApplicant) {
		this.jobApplicant = jobApplicant;
	}
	
	public JobApplicant getJobApplicantForConfirmationDialog() {
		return jobApplicantForConfirmationDialog;
	}
	
	public void setJobApplicantForConfirmationDialog(JobApplicant jobApplicantForConfirmationDialog) {
		this.jobApplicantForConfirmationDialog = jobApplicantForConfirmationDialog;
	}
	
	public void saveJobApplicant() {
		service.addJobApplicant(jobApplicant);
		jobApplicantForConfirmationDialog = new JobApplicant();
		jobApplicantForConfirmationDialog.setFirstName(jobApplicant.getFirstName().trim());
		jobApplicantForConfirmationDialog.setLastName(jobApplicant.getLastName().trim());
		jobApplicantForConfirmationDialog.setGender(jobApplicant.getGender());
		jobApplicantForConfirmationDialog.setMotive((jobApplicant.getMotive() != null) ? jobApplicant.getMotive().trim() : null);
		clearJobApplicant();
		RequestContext.getCurrentInstance().execute("PF('registrationConfirmationDialog').show()");
	}
	
	public void clearJobApplicant() {
		setJobApplicant(new JobApplicant());
	}
}