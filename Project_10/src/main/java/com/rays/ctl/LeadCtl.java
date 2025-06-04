package com.rays.ctl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.LeadDTO;

import com.rays.form.LeadForm;
import com.rays.form.PrescriptionForm;
import com.rays.service.LeadServiceInt;


@RestController
@RequestMapping(value = "Lead")
public class LeadCtl extends BaseCtl<LeadForm, LeadDTO, LeadServiceInt>{
	
	@Autowired
	private LeadServiceInt leadServiceInt;
	
	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> map=new HashMap<Integer, String>();
		map.put(1, "Hot");
		map.put(2, "Warm");
		map.put(3, "Cold");
		
		
		res.addResult("lead", map);
		return res;

//		PrescriptionDTO dto = new PrescriptionDTO();
//
//		List<DropdownList> list = prescriptionServiceInt.search(dto, userContext);
//		res.addResult("prescriptionlist", list);
//		return res;
	}


}
