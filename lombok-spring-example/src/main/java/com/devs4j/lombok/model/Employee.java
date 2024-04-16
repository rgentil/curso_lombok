package com.devs4j.lombok.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Singular;

@Data
@AllArgsConstructor
@Builder
public class Employee {
	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String nickName;
	private int age;
	private float salary;
	private EmployeeType type;
	private List<String> addresses;
	
	@Singular
	private List<String> sports;
	
	@Default
	private LocalDateTime lastUpdateTs = LocalDateTime.now();
	private LocalDateTime createTs;

}
