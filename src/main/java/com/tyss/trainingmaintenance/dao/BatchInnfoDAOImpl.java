package com.tyss.trainingmaintenance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.tyss.trainingmaintenance.dto.BatchInfo;

@Repository
public class BatchInnfoDAOImpl implements  BatchInfoDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public BatchInfo addBatch(BatchInfo batch) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(batch);
			transaction.commit();
			return batch;
		} catch (Exception e) {
			manager.close();
			e.printStackTrace();
			return null;
		}
	}

}
