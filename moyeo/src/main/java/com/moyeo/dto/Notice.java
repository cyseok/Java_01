package com.moyeo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
	public class Notice {
		private int noticeNum; 
		private String noticeTitle;
		private String noticeContent;
		private String noticeRegdate;
		private int noticeStatus;
	}


