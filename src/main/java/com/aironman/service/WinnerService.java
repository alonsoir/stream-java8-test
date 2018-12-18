package com.aironman.service;

import java.util.List;

import com.aironman.pojo.Winners;

public interface WinnerService {

	Winners create (Winners entity);
	List<Winners> getByFrequency();
	void dropData();
}
