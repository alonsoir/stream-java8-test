package com.aironman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.pojo.OutputEntity;
import com.aironman.repository.OutputRepository;

@Service
public class OutputServiceImpl implements OutputService{

	@Autowired
	private final OutputRepository repository;
	
	public OutputServiceImpl(OutputRepository repository){
		this.repository=repository;
	}
	
	@Override
	@Transactional(readOnly = false)
	public OutputEntity create(OutputEntity entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OutputEntity> getByFrequency(Float frequency) {
		// TODO Auto-generated method stub
		return repository.sortOrderByFrequency(frequency);
	}

	@Transactional(readOnly= true)
	public void dropData() {
		repository.deleteAll();
	}
}
