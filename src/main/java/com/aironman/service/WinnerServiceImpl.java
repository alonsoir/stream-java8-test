package com.aironman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Winners create(Winners entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Winners> getByFrequency() {
		// TODO Auto-generated method stub
		return repository.sortOrderByFrequency();
	}

	@Override
	public void dropData() {
		// TODO Auto-generated method stub
		repository.deleteAll();
	}

}
