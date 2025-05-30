package com.rays.dto;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_PRODUCT")
public class ProductDTO extends BaseDTO{
	

	@Column(name = "NAME", length = 50)
	private String name = null;

	@Column(name = "DESCRIPTION", length = 100)
	private String description = null;

	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getKey() {
		return name;
	}

	
	public String getValue() {
		return name;
	}


	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "name";
	}


	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return name;
	}


	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return name;
	}


	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("name", "asc");
		return map;
	}


	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("name", name);
		return map;
	}

}