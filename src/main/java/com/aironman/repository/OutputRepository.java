package com.aironman.repository;


import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.aironman.pojo.OutputEntity;

public interface OutputRepository extends CrudRepository<OutputEntity,Long>{

	@Query("Select * from OUTPUT_ENTITY as entity order by entity.frequency")
	List<OutputEntity> sortOrderByFrequency(Float frequency);

}
