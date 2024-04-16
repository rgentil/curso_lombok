package com.devs4j.lombok.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NonNull;

@Data
public class Role {
	
	private Integer id;
	@NonNull
	private String name;
	private LocalDateTime lasUpdateTs;
	private LocalDateTime createTs;

}
