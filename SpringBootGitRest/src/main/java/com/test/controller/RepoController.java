package com.test.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.atomic.GetRepoAtomic;
import com.test.model.RepoEntity;
import com.test.model.RepoModel;
import com.test.service.RepoService;

@RestController
public class RepoController {

	@Autowired
	GetRepoAtomic getRepoAtomic;

	@Autowired
	RepoService repoService;
	
	//This Controller is used to get owner name and repo name and will  call the Git API to fetch Public repository details

	@GetMapping(value = "/repositories/{owner}/{repository­name}")
	public RepoModel getRepoDetails(@PathVariable("owner") String ownerName,
			@PathVariable("repository­name") String repositoryName)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		RepoEntity entityDetails = repoService
				.fetchDetails(Optional.of(ownerName).orElse("") + "/" + Optional.of(repositoryName).orElse(""));
		if (null != entityDetails) {
			RepoModel respModel = new RepoModel();
			PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
			propertyUtilsBean.copyProperties(respModel, entityDetails);
			return respModel;
		}

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("owner", Optional.of(ownerName).orElse(""));
		paramMap.put("repo", Optional.of(repositoryName).orElse(""));
		RepoModel response = getRepoAtomic.getRepo(paramMap);
		RepoEntity entity = new RepoEntity();
		PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
		propertyUtilsBean.copyProperties(entity, response);
		repoService.save(entity);
		return response;

	}

}
