package edu.utd.ecs.db.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchDTO {
	
	private String isbn;
	private String title;
	private String author_name;
	private String isavailable;

}
