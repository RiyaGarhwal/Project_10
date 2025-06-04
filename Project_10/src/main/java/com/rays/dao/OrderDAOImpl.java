package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.OrderDTO;



@Repository
public class OrderDAOImpl extends BaseDAOImpl<OrderDTO> implements OrderDAOInt{

	@Override
	protected List<Predicate> getWhereClause(OrderDTO dto, CriteriaBuilder builder, Root<OrderDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (!isEmptyString(dto.getProductName())) {

			whereCondition.add(builder.like(qRoot.get("productName"), dto.getProductName()+ "%"));
		}

        if (dto.getOrderDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("orderDate"), dto.getOrderDate()));
        }

//        if (dto.getFees() != null) {
//            whereCondition.add(builder.equal(qRoot.get("fees"), dto.getFees()));
//        }
        
        if (!isZeroNumber(dto.getQuantity())) {       

			whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()));
		}

//        if (dto.getPatient() != null && !dto.getPatient().isEmpty()) {
//            whereCondition.add(builder.like(qRoot.get("patient"), dto.getPatient()));
//        }
        
        if (!isEmptyString(dto.getCustomer())) {

			whereCondition.add(builder.like(qRoot.get("customer"), dto.getCustomer() + "%"));
		}
        
        

        return whereCondition;
		

	}

	@Override
	public Class<OrderDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return OrderDTO.class;
	}

}
