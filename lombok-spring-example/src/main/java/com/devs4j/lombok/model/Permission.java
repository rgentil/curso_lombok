package com.devs4j.lombok.model;

import java.time.LocalDateTime;

import lombok.ToString;
import lombok.Value;

@Value
public class Permission {
	@ToString.Exclude
	private int id;
	private String name;
	private LocalDateTime createTs;

}
