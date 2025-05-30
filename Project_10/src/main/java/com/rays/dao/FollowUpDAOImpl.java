package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.FollowUpDTO;

@Repository
public class FollowUpDAOImpl extends BaseDAOImpl<FollowUpDTO> implements FollowUpDAOInt{

	@Override
	protected List<Predicate> getWhereClause(FollowUpDTO dto, CriteriaBuilder builder, Root<FollowUpDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

    	

        if (dto.getVisitDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("visitDate"), dto.getVisitDate()));
        }

//        if (dto.getFees() != null) {
//            whereCondition.add(builder.equal(qRoot.get("fees"), dto.getFees()));
//        }
        
        if (!isZeroNumber(dto.getFees())) {       

			whereCondition.add(builder.equal(qRoot.get("fees"), dto.getFees()));
		}

//        if (dto.getPatient() != null && !dto.getPatient().isEmpty()) {
//            whereCondition.add(builder.like(qRoot.get("patient"), dto.getPatient()));
//        }
        
        if (!isEmptyString(dto.getPatient())) {

			whereCondition.add(builder.like(qRoot.get("patient"), dto.getPatient() + "%"));
		}
        
        if (dto.getDoctor() != null && !dto.getDoctor().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("doctor"), dto.getDoctor()));
        }

        return whereCondition;
		
	}

	@Override
	public Class<FollowUpDTO> getDTOClass() {
		return FollowUpDTO.class;
	}
	
	

}
