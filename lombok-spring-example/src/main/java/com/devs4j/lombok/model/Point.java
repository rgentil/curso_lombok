package com.devs4j.lombok.model;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.With;

@AllArgsConstructor
@ToString
public class Point {
	@With
	private final String name;
	@With
	private final int x;
	@With
	private final int y;
}
