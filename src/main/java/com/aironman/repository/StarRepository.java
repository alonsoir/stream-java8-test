package com.aironman.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.aironman.pojo.Stars;

public interface StarRepository extends CrudRepository<Stars, Long>{
	
	@Query("Select * from STARS order by frequency")
	List<Stars> sortOrderByFrequency();
}
