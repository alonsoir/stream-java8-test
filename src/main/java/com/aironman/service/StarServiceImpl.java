package com.aironman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.pojo.Stars;
import com.aironman.repository.StarRepository;

@Service
public class StarServiceImpl implements StarService{

	@Autowired
	StarRepository repository;
	
	public StarServiceImpl(StarRepository repository) {
		this.repository=repository;
	}
	@Override
	@Transactional
	public Stars create(Stars entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Stars> getByFrequency() {
		// TODO Auto-generated method stub
		return repository.sortOrderByFrequency();
	}

	@Override
	@Transactional
	public void dropData() {
		// TODO Auto-generated method stub
		repository.deleteAll();
	}

}
