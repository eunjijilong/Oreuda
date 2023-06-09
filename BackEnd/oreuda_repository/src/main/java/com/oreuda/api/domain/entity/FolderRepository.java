package com.oreuda.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "repository")
public class FolderRepository {

	// 기본키
	@Id
	@Column(name = "repository_id")
	private String id;

	// 폴더
	@NotNull
	@ManyToOne
	@JoinColumn(name = "folder_id")
	private Folder folder;

	public void updateFolder(Folder folder) {
		System.out.println("in updateFolder");
		this.folder = folder;
	}
}
