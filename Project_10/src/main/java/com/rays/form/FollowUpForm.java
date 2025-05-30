package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.FollowUpDTO;

public class FollowUpForm extends BaseForm{
	
	 

	    @PastOrPresent(message = "VisitDate  must be today or in the past")
	    @NotNull(message = "Please enter visit date")
	    private Date visitDate;

	    
	    
	    @NotEmpty(message = "Please select a patient")
	    private String patient ;
	    
	    @NotEmpty(message = "Please select a doctor")
	    private String doctor ;
	
	
	    @NotNull(message = "Please enter Fees")
	    @Min(value = 1, message = "Fees amount should be more than 1")
	    @Max(value = 999999, message = " Fees amount should have only 6 digits")
	    private Long fees;


		public Date getVisitDate() {
			return visitDate;
		}


		public void setVisitDate(Date visitDate) {
			this.visitDate = visitDate;
		}


		public String getPatient() {
			return patient;
		}


		public void setPatient(String patient) {
			this.patient = patient;
		}


		public String getDoctor() {
			return doctor;
		}


		public void setDoctor(String doctor) {
			this.doctor = doctor;
		}


		public Long getFees() {
			return fees;
		}


		public void setFees(Long fees) {
			this.fees = fees;
		}
		
		@Override
	    public BaseDTO getDto() {
			FollowUpDTO dto = initDTO(new FollowUpDTO());
	        dto.setVisitDate(visitDate);
	        dto.setFees(fees);
	        dto.setPatient(patient);
	        dto.setDoctor(doctor);
	        return dto;
	    }

}
