package com.ambula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_location")
@Entity
public class User {
	
	@Id
	private Integer userId;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private user_type type;
	
	private Double latitude;
	
	private Double longitude;
	
	
	
//	private Double distance = Math.sqrt(Math.pow(this.latitude, 2) + Math.pow(this.longitude, 2));

}
