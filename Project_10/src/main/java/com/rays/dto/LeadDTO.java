package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "ST_LEAD")
public class LeadDTO extends BaseDTO{
	
	@Column(name = "DATE")
    private Date date;

    @Column(name = "CONTACT_NAME", length = 50)
    private String contactName;
    
    @Column(name = "MOBILE", length = 50)
	private String mobile;
    
    @Column(name = "STATUS", length = 50)
    private String status;
	
	

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "status";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("status", "asc");
        return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("status",status );
        return map;
	}

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
	
}
