package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.OrderDTO;

import com.rays.form.OrderForm;

import com.rays.service.OrderServiceInt;



@RestController
@RequestMapping(value = "Order")
public class OrderCtl extends BaseCtl<OrderForm, OrderDTO, OrderServiceInt>{
	
	@Autowired
	private OrderServiceInt orderServiceInt;
	
	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

//		HashMap<Integer, String> map=new HashMap<Integer, String>();
//		map.put(1, "Kamal");
//		map.put(2, "Raju");
//		map.put(3, "Santa");
//		
//		
//		res.addResult("patient", map);
//		return res;

		OrderDTO dto = new OrderDTO();

		List<DropdownList> list = orderServiceInt.search(dto, userContext);
		res.addResult("orderlist", list);
		return res;
	}


}
