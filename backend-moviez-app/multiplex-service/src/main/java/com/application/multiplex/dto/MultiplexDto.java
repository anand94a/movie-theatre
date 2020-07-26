package com.application.multiplex.dto;

import java.util.Set;

import com.application.multiplex.document.Multiplex;

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
public class MultiplexDto {
	
	private String multiplexId;
	private String multiplexName;
	private String city;
	private int numberOfScreens;
	private Set<Integer> setOfScreens;
}
