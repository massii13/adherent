package fr.ols.webappli.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Section extends AbstractEntities {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "section_generator")
	@SequenceGenerator(name = "section_generator", sequenceName = "section_sequence", initialValue = 9, allocationSize = 1)
	private Long id;
	private String code;
	private String libelle;

}
