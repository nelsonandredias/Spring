package com.java.springbootresth2basics.exceptions;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CustomErrorMessage {
	
	//Generic Exception Structure to return every time there is an error:
		/*
		 1. timestamp
		 2. message
		 3. details
		 4. status
		*/
		
		private Date timestamp;
		private String message;
		private List<String> details;
		private int status;
		
		public CustomErrorMessage() {
			
		}
		
		public CustomErrorMessage(Date timestamp, String message, List<String> details, int status) {
			super();
			this.timestamp = timestamp;
			this.message = message;
			this.details = details;
			this.status = status;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

		public List<String> getDetails() {
			return details;
		}

		public void setDetails(List<String> details) {
			this.details = details;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}


		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
		
}
