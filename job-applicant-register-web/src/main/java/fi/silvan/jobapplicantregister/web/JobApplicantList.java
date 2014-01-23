package fi.silvan.jobapplicantregister.web;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fi.silvan.jobapplicantregister.model.entity.JobApplicant;
import fi.silvan.jobapplicantregister.service.JobApplicantServiceBean;

@ManagedBean
@RequestScoped
public class JobApplicantList {
	@EJB
	private JobApplicantServiceBean service;
	private List<JobApplicant> jobApplicants = new ArrayList<JobApplicant>();
	
	public List<JobApplicant> getJobApplicants() {
		return jobApplicants;
	}
	
	public void setJobApplicants(List<JobApplicant> jobApplicants) {
		if (jobApplicants != null) {
			this.jobApplicants = jobApplicants;
		}
	}
	
	public String refreshJobApplicants() {
		jobApplicants = service.getJobApplicants();
		return "";
	}
}