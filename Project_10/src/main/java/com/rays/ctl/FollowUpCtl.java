package com.rays.ctl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.FollowUpDTO;
import com.rays.form.FollowUpForm;
import com.rays.service.FollowUpServiceInt;

@RestController
@RequestMapping(value = "FollowUp")
public class FollowUpCtl extends BaseCtl<FollowUpForm, FollowUpDTO, FollowUpServiceInt> {

	@Autowired
	private FollowUpServiceInt followupserviceint;
	
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

		FollowUpDTO dto = new FollowUpDTO();

		List<DropdownList> list = followupserviceint.search(dto, userContext);
		res.addResult("followuplist", list);
		return res;
	}

}
