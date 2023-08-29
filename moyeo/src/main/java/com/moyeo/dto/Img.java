package com.moyeo.dto;

import lombok.Data;

@Data
public class Img {
	private String imgIdx;
	private String fileName;
	private String uploadPath;
	private int packIdx;
	private int diyIdx;
	private int reviewIdx;
	private int qaIdx;
	private int noticeIdx;
}
