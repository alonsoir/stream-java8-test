package com.aironman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aironman.pojo.OutputEntity;
import com.aironman.repository.OutputRepository;

@Service
public class OutputServiceImpl implements OutputService{

	@Autowired
	OutputRepository repository;
	
	@Override
	public OutputEntity create(OutputEntity entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<OutputEntity> getByFrequency(Float frequency) {
		// TODO Auto-generated method stub
		return repository.sortOrderByFrequency(frequency);
	}

}
