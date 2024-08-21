package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.RepoEntity;

public interface RepoRepository extends JpaRepository<RepoEntity, Long> {

	RepoEntity findByfullName(String fullName);

}
