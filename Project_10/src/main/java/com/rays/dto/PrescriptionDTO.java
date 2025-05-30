package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_PRESCRIPTION")
public class PrescriptionDTO extends BaseDTO{
	
	@Column(name = "NAME", length = 50)
    private String name;
	
	@Column(name = "DECEASE", length = 50)
    private String decease;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "CAPACITY")
	private Long capacity;


    public String getKey() {
		return id +"";
	}
    
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return decease;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "decease";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return decease;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return decease;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("decease", "asc");
        return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("decease",decease );
        return map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecease() {
		return decease;
	}

	public void setDecease(String decease) {
		this.decease = decease;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

}
