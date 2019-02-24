package fr.ols.webappli.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends AbstractEntities {

	@Id
	@Column(name = "id_admin", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_generator")
	@SequenceGenerator(name = "action_generator", sequenceName = "action_seq")
	private Long idAdmin;
	
	@Column(name = "civilite", length=25, nullable = false)
	private String civilite;
	
	@Column(name = "nom",length=25, nullable = false)
	private String nom;
	
	@Column(name = "prenom", length=25, nullable = false)
	private String prenom;
	
	@Column(name = "date_naissance", nullable = true)
	private LocalDateTime dateNaissance;

}
