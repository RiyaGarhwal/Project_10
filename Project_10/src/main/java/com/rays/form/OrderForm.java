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
import com.rays.dto.OrderDTO;


public class OrderForm extends BaseForm {

	@Pattern(regexp = "^[A-Za-z ]+$", message = "Only letters are Allowed")
	@NotEmpty(message = "Please enter ProductName")
	private String productName;

	@PastOrPresent(message = "Date  must be today or in the past")
	@NotNull(message = "Please enter  date")
	private Date orderDate;

	@NotNull(message = "Please enter quantity")
	@Min(value = 1, message = "quantity amount should be more than 1")
	@Max(value = 9999, message = "quantity amount should have only 4 digits")
	private Long quantity;

	@NotEmpty(message = "Please select a customer")
	private String customer;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	@Override
    public BaseDTO getDto() {
		OrderDTO dto = initDTO(new OrderDTO());
        dto.setProductName(productName);
        dto.setCustomer(customer);
        dto.setOrderDate(orderDate);
        dto.setQuantity(quantity);
        return dto;
    }

	

}
