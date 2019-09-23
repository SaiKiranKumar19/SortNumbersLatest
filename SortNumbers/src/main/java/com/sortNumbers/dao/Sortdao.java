package com.sortNumbers.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sortNumbers.entity.sortEntity;



@Service
public class Sortdao {
	
	@Autowired
	SortRepository sortRepo;
	
	/**
	 * Retrieve All Values from database
	 * 
	 * @return
	 */
	@Transactional
	public List<sortEntity> getAllSortNumbers() {
		List<sortEntity> entityResult = new ArrayList<sortEntity>();
		sortRepo.findAll().
		forEach(resultRow -> entityResult
		.add(resultRow));
		return entityResult;
	}


	@Transactional
	public void saveOrUpdate(sortEntity sortNumber) {
		sortRepo.save(sortNumber);
	}
}
