package com.oreuda.api.domain.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDto {

	// 고유 ID
	String id;

	// 이름
	String name;

	// 설명
	String description;

	// URL
	String url;

	// 주 사용언어
	String language;

	// 공개여부
	String isPrivate;

	// star 수
	int starCount;

	// 수정일시
	String updateDate;

	// 사용자 커밋 수
	int commitCount;

	// 연도별 커밋
	@Builder.Default
	List<YearlyCommitDto> yearlyCommits = new ArrayList<>();

	// 일자별 커밋
	@Builder.Default
	List<DailyCommitDto> dailyCommits = new ArrayList<>();
}
