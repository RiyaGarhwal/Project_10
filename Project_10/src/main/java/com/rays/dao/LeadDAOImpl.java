package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.LeadDTO;
import com.rays.dto.PrescriptionDTO;

@Repository
public class LeadDAOImpl extends BaseDAOImpl<LeadDTO> implements LeadDAOInt{
	
	

	@Override
	protected List<Predicate> getWhereClause(LeadDTO dto, CriteriaBuilder builder, Root<LeadDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (!isEmptyString(dto.getContactName())) {

			whereCondition.add(builder.like(qRoot.get("contactName"), dto.getContactName()+ "%"));
		}

        if (dto.getDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("date"), dto.getDate()));
        }

//        if (dto.getFees() != null) {
//            whereCondition.add(builder.equal(qRoot.get("fees"), dto.getFees()));
//        }
        if (dto.getMobile() != null) {
            whereCondition.add(builder.equal(qRoot.get("mobile"), dto.getMobile()));
        }
        

//        if (dto.getPatient() != null && !dto.getPatient().isEmpty()) {
//            whereCondition.add(builder.like(qRoot.get("patient"), dto.getPatient()));
//        }
        
        if (!isEmptyString(dto.getStatus())) {

			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
		}
        
        

        return whereCondition;

	}

	@Override
	public Class<LeadDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return LeadDTO.class;
	}

}
