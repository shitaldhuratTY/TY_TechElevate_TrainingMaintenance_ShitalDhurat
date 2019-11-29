package com.tyss.trainingmaintenance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.trainingmaintenance.dao.BatchInfoDAO;
import com.tyss.trainingmaintenance.dto.BatchInfo;

@Service
public class ServiceDAOImpl implements ServiceDAO {
	
	@Autowired
	BatchInfoDAO dao;
	
	@Override
	public BatchInfo addBatch(BatchInfo batch) {
		return dao.addBatch(batch);
	}

}
