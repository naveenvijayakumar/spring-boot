package com.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class RepoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "description")
	private String description;

	@Column(name = "clone_url")
	private String cloneUrl;

	@Column(name = "stars")
	private int stars;

	@Column(name = "created_at")
	private String createdAt;

	}
