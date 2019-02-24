package fr.ols.webappli.service;

import org.springframework.stereotype.Service;

import fr.ols.webappli.dao.ISectionDao;
import fr.ols.webappli.entities.Section;

@Service
public class SectionService extends AbstractEntitiesService<Section, ISectionDao> {

	public SectionService() {
		super(Section.class, ISectionDao.class); 

}
	}
