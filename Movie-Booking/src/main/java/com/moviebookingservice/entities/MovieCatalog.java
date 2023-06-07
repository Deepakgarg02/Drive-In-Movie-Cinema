package com.moviebookingservice.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieCatalog {

	private String title;
	private String description;
	private String genre;
	private String imdbRating;

}
