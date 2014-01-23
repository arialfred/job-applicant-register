package fi.silvan.jobapplicantregister.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class representing job applicant.
 */
@Entity
@Table(name = "jobapplicant")
public class JobApplicant implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int jobApplicantId;
	private String firstName;
	private String lastName;
	private int gender;
	private String motive;
	
	/**
	 * Creates a new job applicant with empty information.
	 */
	public JobApplicant() {
	}
	
	/**
	 * Creates a new job applicant with specified id, first name, last name, gender and motive.
	 * 
	 * @param jobApplicantId unique id of this job applicant
	 * @param firstName first name of this job applicant
	 * @param lastName last name of this job applicant
	 * @param gender gender of this job applicant (<code>1</code> = male, <code>2</code> = female)
	 * @param motive motive (why he/she is applying to this job) of this job applicant
	 */
	public JobApplicant(int jobApplicantId, String firstName, String lastName, int gender, String motive) {
		this.jobApplicantId = jobApplicantId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.motive = motive;
	}
	
	/**
	 * Returns the unique id of this job applicant.
	 * 
	 * @return the unique id of this job applicant
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobapplicant_id", nullable = false)
	public int getJobApplicantId() {
		return jobApplicantId;
	}
	
	/**
	 * Sets the unique id of this job applicant.
	 * 
	 * @param jobApplicantId
	 */
	public void setJobApplicantId(int jobApplicantId) {
		this.jobApplicantId = jobApplicantId;
	}
	
	/**
	 * Returns the first name of this job applicant.
	 * 
	 * @return the first name of this job applicant
	 */
	@Column(name = "firstname", nullable = false, length = 40)
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name of this job applicant.
	 * 
	 * @param firstName the first name of this job applicant
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the last name of this job applicant.
	 * 
	 * @return the last name of this job applicant
	 */
	@Column(name = "lastname", nullable = false, length = 40)
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name of this job applicant.
	 * 
	 * @param lastName the last name of this job applicant.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns the gender of this job applicant as a numeric value (<code>1</code> = male, <code>2</code> = female).
	 * 
	 * @return the gender of this job applicant (<code>1</code> = male, <code>2</code> = female)
	 */
	@Column(name = "gender", nullable = false)
	public int getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender of this job applicant as a numeric value (<code>1</code> = male, <code>2</code> = female).
	 * 
	 * @param gender the gender of this job applicant (<code>1</code> = male, <code>2</code> = female)
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	/**
	 * Returns the motive (why he/she is applying to this job) of this job applicant.
	 * 
	 * @return the motive of this job applicant
	 */
	@Column(name = "motive", nullable = true, length = 500)
	public String getMotive() {
		return motive;
	}
	
	/**
	 * Sets the motive (why he/she is applying to this job) of this job applicant.
	 * 
	 * @param motive the motive of this job applicant
	 */
	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	/**
	 * Returns the string representation of this job applicant.
	 * The exact details of the representation are unspecified and subject to change.
	 * 
	 * @return the string representation of this job applicant
	 */
	@Override
	public String toString() {
		return "Job applicant: id: " + jobApplicantId +
				", first name: " + firstName +
				", last name: " + lastName +
				", gender: " + gender +
				", motive: " + motive;
	}
}