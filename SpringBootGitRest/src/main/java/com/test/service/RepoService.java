package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.RepoEntity;
import com.test.repository.RepoRepository;

@Service
public class RepoService {

	@Autowired
	RepoRepository repoRepository;

	public RepoEntity fetchDetails(String fullName) {
		RepoEntity entity = repoRepository.findByfullName(fullName);
		return entity;
	}

	public RepoEntity save(RepoEntity repoEntity) {
		return repoRepository.save(repoEntity);
	}

}
