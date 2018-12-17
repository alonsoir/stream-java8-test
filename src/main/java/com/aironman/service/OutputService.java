package com.aironman.service;

import java.util.List;

import com.aironman.pojo.OutputEntity;

public interface OutputService {

	OutputEntity create (OutputEntity entity);
	List<OutputEntity> getByFrequency(Float frecuency);
	void dropData();
}
