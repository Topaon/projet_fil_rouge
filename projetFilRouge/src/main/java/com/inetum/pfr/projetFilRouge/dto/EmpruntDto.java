package com.inetum.pfr.projetFilRouge.dto;

import java.util.Date;

import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Personne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class EmpruntDto {
	private Personne personne;
	private Livre livre;
	private Date dateFin;
}
