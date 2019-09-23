package com.sortNumbers.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sortNumbers.entity.sortEntity;



@Repository
public interface SortRepository extends CrudRepository<sortEntity, Integer> {

}
