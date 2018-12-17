package com.aironman.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aironman.pojo.OutputEntity;

public class OutputRepositoryImpl implements OutputRepositoryCustom{

    @Autowired
    OutputRepository repository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
	@Override
	public List<OutputEntity> sortOrderByFrequency(Float frequency) {
		
		final String jql_order_by_frequency ="Select * from OutputEntity as entity order by entity.frequency";
		return this.jdbcTemplate.queryForObject(jql_order_by_frequency, List.class, new Object[] { frequency });
		
	}

}
