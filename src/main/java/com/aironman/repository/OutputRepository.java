package com.aironman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aironman.pojo.OutputEntity;

public interface OutputRepository extends JpaRepository<OutputEntity,Long>,OutputRepositoryCustom{

}
