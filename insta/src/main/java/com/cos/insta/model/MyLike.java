package com.cos.insta.model;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class MyLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;				// Sequence
	
	@ManyToOne
	@JoinColumn(name="userId")
	@JsonIgnoreProperties({"password", "name", "website", "bio", "email", "phone", "gender", "insDt", "updDt"})
	private User user;			// 좋아요 한 유저 정보
	
	@ManyToOne
	@JoinColumn(name="imageId")
	@JsonIgnoreProperties({"user", "likes"})
	private Image image;		// 좋아요 한 게시글(이미지) 정보
	
	@CreationTimestamp
	private Timestamp insDt;	// 입력일시
	
	@CreationTimestamp
	private Timestamp updDt;	// 수정일시
	

	// Like와 User는 N:1 관계이므로 ManyToOne으로 작성, 컬럼이름은 JoinColumn을 이용해 userId로 지정
	// Like와 Image는 N:1 관계이므로 ManyToOne으로 작성, 컬럼이름은 JoinColumn을 이용해 imageId로 지정
	// JsonIgnoreProperties를 이용해 해당 모델에서 사용할 필요 없는 필드는 제외 시킴
}
