package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.LeadDTO;

public class LeadForm extends BaseForm{
	
	
	
	@PastOrPresent(message = "Date  must be today or in the past")
    @NotNull(message = "Please enter  date")
    private Date date;
	
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Only letters are Allowed")
    @NotEmpty(message = "Please enter Name")
	private String contactName ;

	@NotNull(message = "please enter mobile")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "allow only 10 digitis")
	private String mobile;
    
    @NotEmpty(message = "Please select a status")
    private String status ;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    

	@Override
    public BaseDTO getDto() {
		LeadDTO dto = initDTO(new LeadDTO());
        dto.setContactName(contactName);
        dto.setStatus(status);
        dto.setDate(date);
        dto.setMobile(mobile);
        return dto;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	
}
