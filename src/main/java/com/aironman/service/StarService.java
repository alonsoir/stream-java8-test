package com.aironman.service;

import java.util.List;

import com.aironman.pojo.Stars;

public interface StarService {

	Stars create (Stars entity);
	List<Stars> getByFrequency();
	void dropData();
}
