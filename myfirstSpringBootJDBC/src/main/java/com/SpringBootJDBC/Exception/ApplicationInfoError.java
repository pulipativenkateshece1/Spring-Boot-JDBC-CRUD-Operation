package com.SpringBootJDBC.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApplicationInfoError 
{
	private LocalDateTime localDateTime;
	private String message;
	private String description;
	public ApplicationInfoError(LocalDateTime localDateTime, String message, String description) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.description = description;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return description;
	}
	

}
