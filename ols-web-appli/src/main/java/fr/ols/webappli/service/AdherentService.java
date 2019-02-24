package fr.ols.webappli.service;

import org.springframework.stereotype.Service;

import fr.ols.webappli.dao.IAdherentDao;
import fr.ols.webappli.entities.Adherent;

@Service
public class AdherentService extends AbstractEntitiesService<Adherent, IAdherentDao> {

	public AdherentService() {
		super(Adherent.class, IAdherentDao.class);
	}
}

