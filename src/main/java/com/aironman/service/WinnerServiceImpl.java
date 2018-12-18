package com.aironman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.pojo.Winners;
import com.aironman.repository.WinnerRepository;

@Service
public class WinnerServiceImpl implements WinnerService{

	@Autowired
	WinnerRepository repository;
	
	public WinnerServiceImpl(WinnerRepository repository){
		this.repository=repository;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Winners create(Winners entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Winners> getByFrequency() {
		// TODO Auto-generated method stub
		return repository.sortOrderByFrequency();
	}

	@Override
	@Transactional(readOnly=false)
	public void dropData() {
		// TODO Auto-generated method stub
		repository.deleteAll();
	}
	
	@Transactional(readOnly=false)
	public Iterable<Winners> findAll(){
		return repository.findAll();
	}
}
