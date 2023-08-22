package com.inetum.pfr.projetFilRouge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class PersonneDto {
	private Long id;
	private String nom;
	private String prenom;
	private String email;
}