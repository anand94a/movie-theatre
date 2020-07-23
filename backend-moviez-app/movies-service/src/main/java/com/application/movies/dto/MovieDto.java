package com.application.movies.dto;

import org.springframework.data.annotation.Id;

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
public class MovieDto {

	private String movieId;
	private String movieName;
	private String movieCategory;
	private String producer;
	private String director;
	private String releaseDate;

}
