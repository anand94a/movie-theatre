package com.application.allotment.dto;

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
public class AllotmentDto {

	private String allotmentId;
	private String movieName;
	private String multiplexName;
	private String city;
	private int screenNumber;
}
