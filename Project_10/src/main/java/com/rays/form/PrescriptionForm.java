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
import com.rays.dto.FollowUpDTO;
import com.rays.dto.PrescriptionDTO;

public class PrescriptionForm extends BaseForm{
	
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Only letters are Allowed")
    @NotEmpty(message = "Please enter Name")
	private String name ;
	
	@PastOrPresent(message = "Date  must be today or in the past")
    @NotNull(message = "Please enter  date")
    private Date date;

    
    
    @NotEmpty(message = "Please select a decease")
    private String decease ;
    
    

    @NotNull(message = "Please enter capacity")
    @Min(value = 1, message = "Capacity amount should be more than 1")
    @Max(value = 9999, message = "Capacity amount should have only 4 digits")
    private Long capacity;



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getDecease() {
		return decease;
	}



	public void setDecease(String decease) {
		this.decease = decease;
	}



	public Long getCapacity() {
		return capacity;
	}



	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	@Override
    public BaseDTO getDto() {
		PrescriptionDTO dto = initDTO(new PrescriptionDTO());
        dto.setName(name);
        dto.setDecease(decease);
        dto.setDate(date);
        dto.setCapacity(capacity);
        return dto;
    }
}
