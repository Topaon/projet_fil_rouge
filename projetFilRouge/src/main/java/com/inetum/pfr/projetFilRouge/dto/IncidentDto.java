package com.inetum.pfr.projetFilRouge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class IncidentDto {
	private Long id;
	private Long empruntId;
	private String typeIncident; 
	private String nouvelEtat; 
	private String description;
}
