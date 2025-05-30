package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;

import com.rays.dto.PrescriptionDTO;

@Repository
public class PrescriptionDAOImpl extends BaseDAOImpl<PrescriptionDTO> implements PrescriptionDAOInt{

	@Override
	protected List<Predicate> getWhereClause (PrescriptionDTO dto, CriteriaBuilder builder, Root<PrescriptionDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName()+ "%"));
		}

        if (dto.getDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("date"), dto.getDate()));
        }

//        if (dto.getFees() != null) {
//            whereCondition.add(builder.equal(qRoot.get("fees"), dto.getFees()));
//        }
        
        if (!isZeroNumber(dto.getCapacity())) {       

			whereCondition.add(builder.equal(qRoot.get("capacity"), dto.getCapacity()));
		}

//        if (dto.getPatient() != null && !dto.getPatient().isEmpty()) {
//            whereCondition.add(builder.like(qRoot.get("patient"), dto.getPatient()));
//        }
        
        if (!isEmptyString(dto.getDecease())) {

			whereCondition.add(builder.like(qRoot.get("decease"), dto.getDecease() + "%"));
		}
        
        

        return whereCondition;
		
	}

	@Override
	public Class<PrescriptionDTO> getDTOClass() {
		return PrescriptionDTO.class;
	}
	
	


	
	

	

}
