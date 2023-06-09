package com.oreuda.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oreuda.api.domain.dto.InputRepositoryDto;
import com.oreuda.api.domain.dto.OutputRepositoryDto;
import com.oreuda.api.domain.dto.RepositoryDto;
import com.oreuda.api.service.RepositoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/repository")
@RequiredArgsConstructor
public class RepositoryController {

	private final RepositoryService repositoryService;

	/**
	 * 레포지토리 목록 조회
	 * @param userId
	 * @param folderId
	 * @param filtering
	 * @return
	 */
	@GetMapping("{folderId}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<List<RepositoryDto>> getRepositories(@RequestHeader String userId, @PathVariable int folderId,
		@RequestParam String filtering) {
		return new ResponseEntity<>(repositoryService.getRepositories(userId, folderId, filtering), HttpStatus.OK);
	}

	/**
	 * 기본 폴더의 레포지토리 목록 조회
	 * @param userId
	 * @return
	 */
	@GetMapping("base")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<List<OutputRepositoryDto>> getRepositoriesByBaseFolder(@RequestHeader String userId) {
		return new ResponseEntity<>(repositoryService.getRepositoriesByBaseFolder(userId), HttpStatus.OK);
	}

	/**
	 * 다른 폴더로 레포지토리 이동
	 * @param userId
	 * @param inputRepositoryDto
	 * @return
	 */
	@PatchMapping
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<List<RepositoryDto>> moveRepository(@RequestHeader String userId,
		@RequestBody InputRepositoryDto inputRepositoryDto) {
		return new ResponseEntity<>(repositoryService.moveRepository(userId, inputRepositoryDto), HttpStatus.OK);
	}
}
