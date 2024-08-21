package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class RepoModel implements Cloneable {

	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("description")
	private String description;
	@JsonProperty("clone_url")
	private String cloneUrl;
	@JsonProperty("stargazers_count")
	private int stars;
	@JsonProperty("created_at")
	private String createdAt;

	}
