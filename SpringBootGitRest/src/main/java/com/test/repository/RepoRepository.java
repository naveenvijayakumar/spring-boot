package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.RepoEntity;

public interface RepoRepository extends JpaRepository<RepoEntity, Long> {

	//Repository to fetch fullname in data base
	RepoEntity findByfullName(String fullName);

}
