package com.test.atomic;

import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

import com.test.model.RepoModel;

@Service
public class GetRepoAtomic {

	private final RestClient restClient;

	public GetRepoAtomic() {
		restClient = RestClient.builder().baseUrl("https://api.github.com").build();
	}

	public RepoModel getRepo(Map<String, String> paramMap) {
		RepoModel entity = restClient.get().uri("/repos/{owner}/{repo}", paramMap).retrieve()
				.onStatus(statusCode -> statusCode.value() == 404, (request, response) -> {
					throw new ResponseStatusException(response.getStatusCode(), "Owner or Repo Not Found");
				}).onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
					throw new ResponseStatusException(response.getStatusCode(), "Server Error Please retry again");
				}).body(RepoModel.class);
		return entity;
	}

}
