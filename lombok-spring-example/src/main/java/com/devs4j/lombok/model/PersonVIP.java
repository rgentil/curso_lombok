package com.devs4j.lombok.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
public class PersonVIP extends Person{
	
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	private int idVIP;

}
