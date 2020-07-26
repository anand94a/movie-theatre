package com.application.search.model;

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
@EqualsAndHashCode
@ToString
public class Allotment {
	private String allotmentId;
	private String movieName;
	private String multiplexName;
	private String city;
	private int screenNumber;
}
