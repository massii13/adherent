package fr.ols.webappli.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ols.webappli.dao.IAdherentDao;
import fr.ols.webappli.entities.Adherent;
import fr.ols.webappli.service.AdherentService;

@RestController
@RequestMapping("/adherents")
public class AdherentController extends AbstracEntitiesController<Adherent, IAdherentDao, AdherentService> {

	public AdherentController() {
		super(AdherentService.class);
	}
}
