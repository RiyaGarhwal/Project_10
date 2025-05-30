package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.FollowUpDAOInt;
import com.rays.dto.FollowUpDTO;

@Service
@Transactional
public class FollowUpServiceImpl extends BaseServiceImpl<FollowUpDTO, FollowUpDAOInt> implements FollowUpServiceInt{
	
	

}
