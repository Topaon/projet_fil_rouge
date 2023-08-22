package com.inetum.pfr.projetFilRouge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class LivreDto {
	private Long id;
	private String titre;
	private String auteur;
	private String editeur;
	private Boolean dispo;
}
