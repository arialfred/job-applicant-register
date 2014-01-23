package fi.silvan.jobapplicantregister.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fi.silvan.jobapplicantregister.model.entity.JobApplicant;

/**
 * EJB providing services to handle job applicants.
 */
@Stateless
public class JobApplicantServiceBean {
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Adds new job applicant to the system persisting it to the data store.
	 * 
	 * @param jobApplicant job applicant to be added
	 */
	public void addJobApplicant(JobApplicant jobApplicant) {
		validateJobApplicant(jobApplicant);
		em.persist(jobApplicant);
	}
	
	/**
	 * Validates given job applicant.
	 * 
	 * @param jobApplicant job applicant to be validated
	 */
	private void validateJobApplicant(JobApplicant jobApplicant) {
		// Check that object is not null
		if (jobApplicant == null) {
			throw new IllegalArgumentException("Job applicant cannot be null.");
		}
		// Validate first name
		String firstName = jobApplicant.getFirstName();
		firstName = (firstName != null) ? firstName.trim() : null;
		if (firstName == null || firstName.length() == 0 || firstName.length() > 40) {
			throw new IllegalArgumentException("First name of the job applicant is not valid.");
		}
		jobApplicant.setFirstName(firstName);
		// Validate last name
		String lastName = jobApplicant.getLastName();
		lastName = (lastName != null) ? lastName.trim() : null;
		if (lastName == null || lastName.length() == 0 || lastName.length() > 40) {
			throw new IllegalArgumentException("Last name of the job applicant is not valid.");
		}
		jobApplicant.setLastName(lastName);
		// Validate gender
		int gender = jobApplicant.getGender();
		if (gender < 1 || gender > 2) {
			throw new IllegalArgumentException("Gender of the job applicant is not valid.");
		}
		// Trim motive
		String motive = jobApplicant.getMotive();
		if (motive != null) {
			jobApplicant.setMotive(motive.trim());
		}
	}
	
	/**
	 * Returns the list of all job applicants in the system.
	 * 
	 * @return all job applicants as a list
	 */
	public List<JobApplicant> getJobApplicants() {
		return em.createQuery("select ja from JobApplicant ja", JobApplicant.class).getResultList();
	}
}