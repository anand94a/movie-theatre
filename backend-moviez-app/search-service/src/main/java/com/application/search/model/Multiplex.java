package com.application.search.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Multiplex {
	private String multiplexId;
	private String multiplexName;
	private String city;
	private int numberOfScreens;
	private Set<Integer> setOfScreens;
}
