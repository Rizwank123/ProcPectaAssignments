package com.procpecta.dev.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	 @JsonProperty("id")

	    private Integer id;

	    @JsonProperty("title")

	    private String title;

	    @JsonProperty("price")

	    private Double price;

	    @JsonProperty("description")

	    private String description;

	    @JsonProperty("image")

	    private String image;

	    @JsonProperty("category")

	    private String category;
	    
	    @JsonProperty ("rating")
	    private Rating rating;
	

}
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Rating {
	@JsonProperty("rate")
	private Double rate;
	
	@JsonProperty("count")
	private int count;
	
}
