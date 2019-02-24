package fr.ols.webappli.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adherent extends AbstractEntities {

	private Long id;
	private String civilite;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private Date dateNaissance;

	private List<Section> sections;

}
