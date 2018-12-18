package com.aironman.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.aironman.pojo.Winners;

public interface WinnerRepository extends CrudRepository<Winners,Long>{
	
	@Query("Select * from WINNERS order by frequency DESC")
	List<Winners> sortOrderByFrequency();

}
