package com.aironman.repository;

import java.util.List;

import com.aironman.pojo.OutputEntity;

public interface OutputRepositoryCustom {

	List<OutputEntity> sortOrderByFrequency(Float frequency);
}
