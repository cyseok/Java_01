package xyz.itwill.dto;

import lombok.Data;

@Data
	public class Notice {
		private int noticeNum; 
		private String noticeTitle;
		private String noticeContent;
		private String noticeRegdate;
		private int noticeStatus;
	}


