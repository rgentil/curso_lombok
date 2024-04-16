package com.devs4j.lombok.model;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	private String name;
	
	@Getter(value = AccessLevel.PRIVATE)
	@Setter(value = AccessLevel.PRIVATE)
	private boolean alive;
	
	@Getter
	@Setter
	@ToString.Exclude
	private String password;	
	
	@Getter
	@Setter
	@NonNull
	private Date date;
}
