package fr.ols.webappli.entities;

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
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adherent extends AbstractEntities {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "adherent_generator")
	@SequenceGenerator(name = "adherent_generator", sequenceName = "adherent_sequence", initialValue = 1, allocationSize = 1)
	private Long idAdherent;
	private String civilite;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private Date dateNaissance;
	
	@ManyToMany (cascade = { CascadeType.ALL })
	private List<Section> sections;


}
